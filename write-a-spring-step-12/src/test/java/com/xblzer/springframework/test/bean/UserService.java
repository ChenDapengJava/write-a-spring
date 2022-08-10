package com.xblzer.springframework.test.bean;

import java.util.Random;

/**
 * @author 行百里者
 * @date 2022-08-08 21:54
 */
public class UserService implements IUserService {
    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "张三，100001，深圳";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }
}
