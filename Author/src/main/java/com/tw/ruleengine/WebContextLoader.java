package com.tw.ruleengine;

public class WebContextLoader extends com.tw.ruleengine.controller.GenericWebContextLoader {

    public WebContextLoader() {
        super("src/test/resources/META-INF/web-resources", false);
    }

}
