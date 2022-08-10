package com.xblzer.springframework.aop.framework.autoProxy;

import com.xblzer.springframework.aop.*;
import com.xblzer.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import com.xblzer.springframework.aop.framework.ProxyFactory;
import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.BeanFactory;
import com.xblzer.springframework.beans.factory.BeanFactoryAware;
import com.xblzer.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.xblzer.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * 融入Bean生命周期的自动代理创建者
 *
 * @author 行百里者
 * @date 2022-08-10 17:40
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    /**
     * 在 Bean 对象初始化之前，执行此方法
     *
     * @param bean     Bean 对象
     * @param beanName Bean 名称
     * @return Bean
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * 在 Bean 对象初始化之后，执行此方法
     *
     * @param bean     Bean 对象
     * @param beanName Bean 名称
     * @return Bean
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param beanClass Bean Class
     * @param beanName  Bean 名称
     * @return Object
     * @throws BeansException BeansException
     */
    @Override
    public Object postProcessorBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (isInfrastructureClass(beanClass)) {
            return null;
        }
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(beanClass)) {
                continue;
            }
            // 封装 AdvisedSupport
            AdvisedSupport advisedSupport = new AdvisedSupport();
            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);
            return new ProxyFactory(advisedSupport).getProxy();
        }
        return null;
    }
}
