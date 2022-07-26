package com.xblzer.springframework.context.support;

/**
 * @author 行百里者
 * @date 2022-07-26 18:34
 */
public class ClasspathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClasspathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
    }

    public ClasspathXmlApplicationContext() {
    }

    public ClasspathXmlApplicationContext(String configLocations) {
        this(new String[]{configLocations});
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
