package com.xblzer.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 行百里者
 * @date 2022-07-25 17:00
 */
public class UserDao {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("1001", "张三");
        map.put("1002", "李四");
        map.put("1003", "王五");
    }

    public String getUserName(String userId) {
        return map.get(userId);
    }
}
