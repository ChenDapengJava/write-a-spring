package com.xblzer.springframework.test.bean;

/**
 * @author chenpeng
 * @date 2022-08-08 21:53
 */
public interface IUserService {
    String queryUserInfo();

    String register(String userName);
}
