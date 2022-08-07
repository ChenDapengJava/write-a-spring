package com.xblzer.springframework.test.bean;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.BeanClassLoaderAware;
import com.xblzer.springframework.beans.factory.BeanFactory;
import com.xblzer.springframework.beans.factory.BeanFactoryAware;
import com.xblzer.springframework.beans.factory.BeanNameAware;
import com.xblzer.springframework.context.ApplicationContext;
import com.xblzer.springframework.context.ApplicationContextAware;

/**
 * @author 行百里者
 * @date 2022-08-04 15:48
 */
public class UserService {

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
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
