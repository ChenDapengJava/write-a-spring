package com.xblzer.springframework.context.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.xblzer.springframework.beans.factory.config.BeanFactoryPostProfessor;
import com.xblzer.springframework.beans.factory.config.BeanPostProfessor;
import com.xblzer.springframework.context.ConfigurableApplicationContext;
import com.xblzer.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * 抽象 应用上下文
 * @author 行百里者
 * @date 2022-07-26 17:30
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object[] args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    /**
     * 根据类型返回 Bean 实例
     *
     * @param type 类型
     * @return
     * @throws BeansException
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    /**
     * 返回注册表中所有的 Bean 名称
     *
     * @return Bean 名称数组
     * @throws BeansException
     */
    @Override
    public String[] getBeanDefinitionNames() throws BeansException {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 核心方法：刷新容器
     *
     * @throws BeansException
     */
    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory ，并加载 BeanDefinition
        refreshBeanFactory();
        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProfessor
        invokeBeanFactoryPostProfessors(beanFactory);
        // 4. BeanPostProfessor
        registerBeanPostProfessor(beanFactory);
        // 5. 提前实例化单例 Bean 对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProfessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProfessor> beanFactoryPostProfessorMap = beanFactory.getBeansOfType(BeanFactoryPostProfessor.class);

        for (BeanFactoryPostProfessor beanFactoryPostProfessor : beanFactoryPostProfessorMap.values()) {
            beanFactoryPostProfessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProfessor(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProfessor> beanPostProfessorMap = beanFactory.getBeansOfType(BeanPostProfessor.class);
        for (BeanPostProfessor beanPostProfessor : beanPostProfessorMap.values()) {
            beanFactory.addBeanPostProfessor(beanPostProfessor);
        }
    }

    /**
     * 钩子，调用销毁方法
     */
    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
