package com.xblzer.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.PropertyValue;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.BeanReference;
import com.xblzer.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.xblzer.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.xblzer.springframework.core.io.Resource;
import com.xblzer.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * 对 XML 文件进行解析，生成 Bean 定义，并装载属性
 * @author 行百里者
 * @date 2022-07-24 16:20
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        /*InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            doLoadBeanDefinition(inputStream);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinition(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource[] resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String[] locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    /**
     * 负责解析 XML
     * @param inputStream
     * @throws ClassNotFoundException
     */
    protected void doLoadBeanDefinition(InputStream inputStream) throws ClassNotFoundException {
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            //判断是否是 Element 元素
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }
            //判断是否是 Bean 标签
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }
            //解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            Class<?> clazz = Class.forName(className);
            //获取 beanName ，优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = clazz.getSimpleName();
            }
            //定义 Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            //获取属性并填充 解析标签 property
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) {
                    continue;
                }
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }
                Element property = (Element) bean.getChildNodes().item(j);
                //属性名称
                String attrName = property.getAttribute("name");
                //属性值
                String attrValue = property.getAttribute("value");
                //依赖属性
                String attrRef = property.getAttribute("ref");
                //属性值：考虑依赖属性的情况
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;

                //属性注入
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            //注册 BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
