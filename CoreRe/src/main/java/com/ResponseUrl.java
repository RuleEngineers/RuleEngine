package com;

public class ResponseUrl {

    String outputPath;
    Rule matchedRule;

    public ResponseUrl( String outputPath, Rule matchedRule){
        this.outputPath = outputPath;
        this.matchedRule = matchedRule;

    }
}
