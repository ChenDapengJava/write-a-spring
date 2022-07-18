package com.xblzer.springframework.bean;

/**
 * @author chenpeng
 * @date 2022-07-18 17:37
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void findUser() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
