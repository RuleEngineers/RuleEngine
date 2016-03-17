package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.String.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RuleParsingService {

    private RuleEngineService ruleEngineService;


    @Autowired
    public RuleParsingService(RuleEngineService ruleEngineService) {
        this.ruleEngineService = ruleEngineService;
    }

    public String parseRule(String string)
    {
        string=string.replaceAll("WHEN",";");
        string=string.replaceAll("THEN", ";");
        string=string.replaceAll("ISGREATERTHAN",">");
        string=string.replaceAll("ISLESSERTHAN","<");
        string=string.replaceAll("ISEQUALS",".equalsIgnoreCase");
        string=string.replaceAll("ISNOTEQUALS","!=");
        string=string.replaceAll("AND","&&");
        string=string.replaceAll("OR","||");
        String condition=getCondition(string);
        String outputPath=getOutputPath(string);
        System.out.println(condition);
        System.out.println(outputPath);
        ruleEngineService.addRule(condition,outputPath,10);
        return "success";

    }

    private String getOutputPath(String string) {

        String condition[]=string.split(";");
        return condition[1];

    }


    private String getCondition(String string) {
        String condition[]=string.split(";");
        return condition[2];
    }
}
