package com.xblzer.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.PropertyValue;
import com.xblzer.springframework.beans.PropertyValues;
import com.xblzer.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.BeanPostProcessor;
import com.xblzer.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 在 Bean 创建时完成前置和后置处理
 * @author 行百里者
 * @date 2022-07-24 11:39
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行 Bean 的初始化方法和 BeanPostProfessor 的前置和后置方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BeansException("实例化 Bean 失败！", e);
        }
        addSingleton(beanName, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Class<?> clazz = beanDefinition.getBeanClass();
        Constructor constructorToUse = null;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor ctor : constructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BeansException("Error set property values:" + beanName);
        }
    }

    /**
     * 初始化 Bean
     * @param beanName
     * @param bean
     * @param beanDefinition
     * @return
     */
    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 1. 执行 BeanPostProfessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // TODO
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        // 2. 执行 BeanPostProfessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);

        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {
        // TODO
    }

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessAfterInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
