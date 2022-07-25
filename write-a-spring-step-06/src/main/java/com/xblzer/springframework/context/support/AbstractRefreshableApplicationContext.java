package com.xblzer.springframework.context.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.xblzer.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author 行百里者
 * @date 2022-07-25 16:31
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }
}
