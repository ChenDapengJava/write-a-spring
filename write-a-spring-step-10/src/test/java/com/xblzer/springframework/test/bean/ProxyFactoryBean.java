package com.xblzer.springframework.test.bean;

import com.xblzer.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 行百里者
 * @date 2022-08-07 21:50
 */
public class ProxyFactoryBean implements FactoryBean<UserDao> {
    /**
     * 获取对象
     *
     * @return 对象
     * @throws Exception Exception
     */
    @Override
    public UserDao getObject() throws Exception {
        InvocationHandler handler = ((proxy, method, args) -> {
            // 添加排除方法
            if ("toString".equals(method.getName())) {
                return this.toString();
            }
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "张三");
            hashMap.put("10002", "李四");
            hashMap.put("10003", "王五");

            return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
        });
        return (UserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserDao.class}, handler);
    }

    /**
     * 对象类型
     *
     * @return 对象类型
     */
    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    /**
     * 是否单例
     *
     * @return 是单例对象返回true，不是单例对象返回false
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
