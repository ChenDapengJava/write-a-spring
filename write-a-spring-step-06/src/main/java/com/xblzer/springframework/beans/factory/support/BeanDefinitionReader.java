package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.core.io.Resource;
import com.xblzer.springframework.core.io.ResourceLoader;

/**
 * BeanDefinition 读取接口
 * @author 行百里者
 * @date 2022-07-24 16:11
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource[] resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String[] locations) throws BeansException;
}
