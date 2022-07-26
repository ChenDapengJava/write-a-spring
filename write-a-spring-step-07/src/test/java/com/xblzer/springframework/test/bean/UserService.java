package com.xblzer.springframework.test.bean;

import com.xblzer.springframework.beans.factory.DisposableBean;
import com.xblzer.springframework.beans.factory.InitializingBean;

/**
 * @author 行百里者
 * @date 2022-07-26 18:42
 */
public class UserService implements InitializingBean, DisposableBean {

    private String userId;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.getUserName(userId) + "," + company + "," + location;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    /**
     * Bean 处理了属性填充后调用
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
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
