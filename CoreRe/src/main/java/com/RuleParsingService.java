package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.String.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RuleParsingService {

    private RuleRepository ruleRepository;


    @Autowired
    public RuleParsingService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public void parseRule(String string)
    {
        string.replaceAll("THEN", ";");
        string.replaceAll("ISGREATERTHAN",">");
        string.replaceAll("ISLESSERTHAN","<");
        string.replaceAll("ISEQUALS",".equalsIgnoreCase");
        string.replaceAll("ISNOTEQUALS","!=");
        string.replaceAll("AND","&&");
        string.replaceAll("OR","||");
        String condition=getConition(string);
        String outputPath=getOutputPath(string);
        System.out.println(string);

    }

    private String getOutputPath(String string) {

        String condition[]=string.split(";");
        return condition[0];

    }


    private String getConition(String string) {
        String condition[]=string.split(";");
        return condition[1];
    }

}
