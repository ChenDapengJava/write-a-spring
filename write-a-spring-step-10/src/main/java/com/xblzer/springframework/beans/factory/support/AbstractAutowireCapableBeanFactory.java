package com.xblzer.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.PropertyValue;
import com.xblzer.springframework.beans.PropertyValues;
import com.xblzer.springframework.beans.factory.*;
import com.xblzer.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.BeanPostProcessor;
import com.xblzer.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author 行百里者
 * @date 2022-08-04 10:39
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubClassingInstantiationStrategy();

    /**
     * 创建 Bean
     *
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 信息定义
     * @param args           参数
     * @return Bean 实例
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行初始化方法及 BeanPostProfessor 的前置后置方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("实例化 Bean 失败", e);
        }
        // 注册实现了 DisposableBean 接口的对象
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        // 判断是否是单例，如果是单例，添加单例到内存
        if (beanDefinition.isSingleton()) {
            addSingleton(beanName, bean);
        }

        return bean;
    }

    /**
     * 创建 Bean 实例
     *
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 信息定义
     * @param args           构造函数参数
     * @return 实例化的 Bean
     */
    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : constructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * Bean 的属性填充
     *
     * @param beanName       Bean 名称
     * @param bean           实例化的 Bean
     * @param beanDefinition Bean 信息定义
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    // 获取引用的实例化对象->递归执行此方法
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Bean [" + beanName + "]属性填充失败", e);
        }
    }

    /**
     * 初始化 Bean
     *
     * @param beanName       Bean 名称
     * @param bean           实例化的 Bean
     * @param beanDefinition Bean 信息定义
     * @return 初始化的 Bean
     */
    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {

        // 感知调用操作
        if (bean instanceof Aware) {
            if (bean instanceof BeanFactoryAware) {
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware) {
                ((BeanClassLoaderAware) bean).setClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }
        }

        // 初始化前置方法（预初始化）
        Object wrappedBean = applyBeanPostProfessorsBeforeInitialization(bean, beanName);
        // 执行初始化
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
        }
        // 执行初始化后置方法
        wrappedBean = applyBeanPostProfessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    /**
     * 调用初始化方法
     *
     * @param beanName       Bean 名称
     * @param bean           实例化的 Bean
     * @param beanDefinition Bean 信息定义
     * @throws Exception Exception
     */
    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        // 1. 实现 InitializingBean 接口
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        // 2. 注解配置 init-method {判断是为了避免二次执行销毁}
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName)) {
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (null == initMethod) {
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            initMethod.invoke(bean);
        }
    }

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean 当前 Bean
     * @param beanName     Bean 名称
     * @return 执行过方法后的 Bean
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public Object applyBeanPostProfessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProfessors()) {
            Object current = beanPostProcessor.postProfessBeforeInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessAfterInitialization 方法
     *
     * @param existingBean 当前 Bean
     * @param beanName     Bean 名称
     * @return 执行过方法后的 Bean
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public Object applyBeanPostProfessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProfessors()) {
            Object current = beanPostProcessor.postProfessAfterInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    /**
     * 注册 DisposableBean
     *
     * @param beanName       Bean 名称
     * @param bean           实例化的 Bean
     * @param beanDefinition Bean 信息定义
     */
    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 如果不是单例的，则不执行销毁
        if (!beanDefinition.isSingleton()) {
            return;
        }
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
