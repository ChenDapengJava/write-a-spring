package com.xblzer.springframework.context.support;

import com.xblzer.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xblzer.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author chenpeng
 * @date 2022-07-26 18:16
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            reader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
