package com.tw.ruleengine.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.String.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RuleParser
{

    public String parseRule(String ruleString)
    {
        ruleString = ruleString.replaceAll("WHEN", ";");
        ruleString = ruleString.replaceAll("THEN", ";");
        ruleString = ruleString.replaceAll("ISGREATERTHAN", ">");
        ruleString = ruleString.replaceAll("ISLESSERTHAN", "<");
        ruleString = ruleString.replaceAll("ISEQUALS",".equalsIgnoreCase");
        ruleString = ruleString.replaceAll("ISNOTEQUALS", "!=");
        ruleString = ruleString.replaceAll("AND", "&");
        ruleString = ruleString.replaceAll("PRIORITY", ";");
        ruleString = ruleString.replaceAll("WEIGHT", ",");
        ruleString = ruleString.replaceAll("EQUALS", "");
        ruleString=shouldRemoveWhiteSpaces(ruleString);

        return ruleString;
    }

    private String shouldRemoveWhiteSpaces(String ruleString)
    {
        return ruleString.replaceAll("\\s+","");
    }
}
