package com.xblzer.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行百里者
 * @date 2022-07-23 20:01
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 添加对象属性
     * @param propertyValue 对象属性
     */
    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
