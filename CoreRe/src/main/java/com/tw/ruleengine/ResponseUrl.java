package com.tw.ruleengine;

public class ResponseUrl {

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    String outputPath;

    public ResponseUrl( String outputPath){
        this.outputPath = outputPath;
    }
}
