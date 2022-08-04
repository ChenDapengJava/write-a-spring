package com.xblzer.springframework.context.support;

import com.xblzer.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xblzer.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author chenpeng
 * @date 2022-08-04 15:00
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    protected abstract String[] getConfigLocations();

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }
}
