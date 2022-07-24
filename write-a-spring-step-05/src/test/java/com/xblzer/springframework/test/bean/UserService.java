package com.xblzer.springframework.test.bean;

/**
 * @author 行百里者
 * @date 2022-07-24 16:56
 */
public class UserService {
    private String userId;

    private UserDao userDao;

    public void findUserById() {
        System.out.println("查询用户信息：" + userDao.getUserName(userId));
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
