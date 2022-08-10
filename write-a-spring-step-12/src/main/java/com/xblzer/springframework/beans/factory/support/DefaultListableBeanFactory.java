package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 行百里者
 * @date 2022-08-04 11:49
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }

    /**
     * 根据类型返回 Bean 实例
     *
     * @param type 类型
     * @return Bean 实例 map 集合
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
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

    /**
     * 根据 Bean 名称查询 BeanDefinition
     *
     * @param beanName Bean 名称
     * @return BeanDefinition Bean 信息定义
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null == beanDefinition) {
            throw new BeansException("No bean name '" + beanName + "' is defined!");
        }
        return beanDefinition;
    }

    /**
     * 是否包含 beanName 的 BeanDefinition
     *
     * @param beanName Bean 名称
     * @return 包含返回true，否则返回false
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 返回注册表中所有 Bean 的名称
     *
     * @return Bean 名称数组
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
