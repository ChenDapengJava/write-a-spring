package com.xblzer.springframework.test.bean;

/**
 * @author 行百里者
 * @date 2022-07-24 16:56
 */
public class UserService {
    private String userId;
    private String company;
    private String location;
    private UserDao userDao;

    public void findUserById() {
        System.out.println("查询用户信息 name=" + userDao.getUserName(userId) + ",company=" + company + ",location=" + location);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
