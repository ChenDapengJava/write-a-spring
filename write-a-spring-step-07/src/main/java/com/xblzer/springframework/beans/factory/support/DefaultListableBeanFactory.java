package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 行百里者
 * @date 2022-07-26 17:00
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void preInstantiateSingletons() throws BeansException {
        this.beanDefinitionMap.keySet().forEach(this::getBean);
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
        Map<String, T> resultMap = new HashMap<>(16);
        this.beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                resultMap.put(beanName, (T) getBean(beanName));
            }
        });
        return resultMap;
    }

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 使用 Bean 名称查询 BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named " + beanName + " is defined.");
        }
        return beanDefinition;
    }

    /**
     * 是否包含指定名称的 BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean containsBeanDefinition(String beanName) throws BeansException {
        return this.beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 获取注册表中所有 Bean 的名称
     *
     * @return
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
