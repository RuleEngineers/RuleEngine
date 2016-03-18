package com.tw.ruleengine.controller;

public class WebContextLoader extends GenericWebContextLoader {

    public WebContextLoader() {
        super("src/test/resources/META-INF/web-resources", false);
    }

}
