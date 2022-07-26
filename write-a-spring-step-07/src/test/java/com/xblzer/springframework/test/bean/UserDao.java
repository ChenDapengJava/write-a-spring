package com.xblzer.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenpeng
 * @date 2022-07-26 18:39
 */
public class UserDao {
    private static Map<String, String> map = new HashMap<>();

    public void initDataMethod(){
        System.out.println("执行：init-method");
        map.put("10001", "张三");
        map.put("10002", "李四");
        map.put("10003", "王五");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        map.clear();
    }

    public String getUserName(String userId) {
        return map.get(userId);
    }
}
