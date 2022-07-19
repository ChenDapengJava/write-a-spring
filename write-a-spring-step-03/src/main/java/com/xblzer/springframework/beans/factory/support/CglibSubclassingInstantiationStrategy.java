package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * Cglib 实例化策略
 * @author 行百里者
 * @date 2022-07-18 17:12
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    /**
     * 实例化方法
     *
     * @param beanDefinition Bean 信息定义
     * @param beanName       Bean 名称
     * @param ctor           构造方法 为了拿到符合入参信息相对应的构造函数
     * @param args           入参信息 最终实例化会用到
     * @return 实例化对象
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (ctor != null) {
            return enhancer.create(ctor.getParameterTypes(), args);
        }
        return enhancer.create();
    }
}
