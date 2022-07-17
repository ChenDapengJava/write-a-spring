package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 核心实现类
 * BeanDefinitionRegistry 接口定义了 Bean 的注册；
 * AbstractAutowireCapableBeanFactory 抽象类定义了 Bean 的获取。
 * 定义和注册最终都集中在 beanDefinitionMap 中了。
 * @author 行百里者
 * @date 2022-07-17 22:59
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 获取 Bean 定义
     * 由实现此抽象类的其他类做相应的实现
     *
     * @param beanName Bean名称
     * @return Bean 的定义信息
     * @throws BeansException 抛出Bean异常
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named" + beanName + " is defined!");
        }
        return beanDefinition;
    }

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 信息定义
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
