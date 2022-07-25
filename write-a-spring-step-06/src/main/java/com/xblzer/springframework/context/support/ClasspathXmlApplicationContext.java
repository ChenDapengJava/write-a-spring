package com.xblzer.springframework.context.support;

/**
 * @author 行百里者
 * @date 2022-07-25 16:44
 */
public class ClasspathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClasspathXmlApplicationContext() {
    }

    public ClasspathXmlApplicationContext(String configLocations) {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     */
    public ClasspathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
