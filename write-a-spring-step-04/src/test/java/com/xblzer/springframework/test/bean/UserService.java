package com.xblzer.springframework.test.bean;

/**
 * @author 行百里者
 * @date 2022-07-19 16:14
 */
public class UserService {
    private String userId;

    private UserDAO userDAO;

    public void findUserById() {
        System.out.println("查询用户信息：" + userDAO.getUserName(userId));
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
