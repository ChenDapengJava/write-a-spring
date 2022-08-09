package com.xblzer.springframework.aop;

/**
 * 被代理的目标对象
 *
 * @author chenpeng
 * @date 2022-08-08 22:30
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
