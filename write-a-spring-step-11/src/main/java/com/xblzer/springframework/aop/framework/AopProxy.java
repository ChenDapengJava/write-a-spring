package com.xblzer.springframework.aop.framework;

/**
 * AOP 代理的抽象
 * 定义一个标准接口，用于获取代理类。因为具体实现代理的方式可以有 JDK 方式，也可以是 Cglib 方式，所以定义接口会更加方便管理实现类。
 *
 * @author 行百里者
 * @date 2022-08-08 22:46
 */
public interface AopProxy {

    Object getProxy();
}
