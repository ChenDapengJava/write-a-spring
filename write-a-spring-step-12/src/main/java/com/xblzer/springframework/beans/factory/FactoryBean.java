package com.xblzer.springframework.beans.factory;

/**
 * 对外提供一个可以二次从 FactoryBean 的 getObject 方法中获取对象的功能即可，这样所有实现此接口的对象类，就可以扩充自己的对象功能了。
 * MyBatis 就是实现了一个 MapperFactoryBean 类，在 getObject 方法中提供 SqlSession 对执行 CRUD 方法的操作
 *
 * @author 行百里者
 * @date 2022-08-04 18:24
 */
public interface FactoryBean<T> {

    /**
     * 获取对象
     *
     * @return 对象
     * @throws Exception Exception
     */
    T getObject() throws Exception;

    /**
     * 对象类型
     *
     * @return 对象类型
     */
    Class<?> getObjectType();

    /**
     * 是否单例
     *
     * @return 是单例对象返回true，不是单例对象返回false
     */
    boolean isSingleton();
}
