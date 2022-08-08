package com.xblzer.springframework.context;

import com.xblzer.springframework.beans.factory.HierarchicalBeanFactory;
import com.xblzer.springframework.beans.factory.ListableBeanFactory;
import com.xblzer.springframework.core.io.ResourceLoader;

/**
 * @author 行百里者
 * @date 2022-08-04 12:16
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
