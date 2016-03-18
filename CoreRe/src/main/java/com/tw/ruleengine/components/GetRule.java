package com.tw.ruleengine.components;

import com.tw.ruleengine.Rule;
import org.springframework.stereotype.Component;

@Component
public class GetRule {

    public Rule getParsedRule(String ruleString)
    {
        String condition = getCondition(ruleString);
        String outputPath = getAction(ruleString);
        Integer priority = getPriority(ruleString);
        return (new Rule(condition,outputPath,priority,0.0));
    }

    private Integer getPriority(String ruleString) {
        String ruleFields[] = ruleString.split(";");
        return Integer.parseInt(ruleFields[3]);
    }

    private String getAction(String ruleString) {

        String ruleFields[] = ruleString.split(";");
        return ruleFields[2];
    }


    private String getCondition(String ruleString) {
        String ruleFields[] = ruleString.split(";");
        return ruleFields[1];
    }
}
