package com.xblzer.springframework.context.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.xblzer.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.xblzer.springframework.beans.factory.config.BeanPostProcessor;
import com.xblzer.springframework.context.ConfigurableApplicationContext;
import com.xblzer.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * 继承 DefaultResourceLoader 是为了处理资源配置 spring.xml 的加载
 * @author 行百里者
 * @date 2022-07-25 15:48
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    /**
     * 核心方法：刷新容器
     *
     * @throws BeansException 抛出 BeansException
     */
    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();

        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProfessor
        invokeBeanFactoryPostProfessors(beanFactory);

        // 4. BeanPostProfessor 需要在其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProfessors(beanFactory);

        // 5. 提前实例化单例 Bean 对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory() throws BeansException;

    private void invokeBeanFactoryPostProfessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProfessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @return
     * @throws BeansException
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    /**
     * Return the names of all beans defined in this registry.
     * <p>
     * 返回注册表中所有的Bean名称
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }
}
