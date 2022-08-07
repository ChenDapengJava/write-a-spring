package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.FactoryBean;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.BeanPostProcessor;
import com.xblzer.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.xblzer.springframework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里原来继承的是 DefaultSingletonBeanRegistry，现在改为继承 FactoryBeanRegistrySupport
 * 这样就可以有扩展 FactoryBean 的能力
 * @author 行百里者
 * @date 2022-08-03 22:33
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object[] args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(String name, Object[] args) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean =  createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if (null == object) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }

    /**
     * 根据 Bean 名称获取 Bean 信息定义
     * @param beanName Bean 的名称
     * @return Bean 信息定义
     * @throws BeansException 抛出 BeansException 异常
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建 Bean
     * @param beanName Bean 名称
     * @param beanDefinition Bean 信息定义
     * @param args 参数
     * @return Bean 实例
     * @throws BeansException 抛出 BeansException 异常
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }

    public List<BeanPostProcessor> getBeanPostProfessors() {
        return beanPostProcessors;
    }
}
