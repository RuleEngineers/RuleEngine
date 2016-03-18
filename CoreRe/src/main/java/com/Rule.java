package com;


import groovy.util.Eval;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Document(collection = "rules")
public class Rule implements Comparable{

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Id
    String ruleId;

    String condition;
    String outputPath;
    Integer priority;
    Double weight;

    public Rule() {

    }

    public Rule(String condition, String outputPath,Integer priority,Double weight) {
        this.condition = condition;
        this.outputPath = outputPath;
        this.priority = priority;
        this.weight=weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Rule)) return false;

        Rule rule = (Rule) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(condition, rule.condition)
                .append(outputPath, rule.outputPath)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(condition)
                .append(outputPath)
                .toHashCode();
    }

    @Override
    public int compareTo(Object o) {
        Rule givenRule = (Rule) o;

        int result = 0;

        if (this.weight.equals(givenRule.weight)) {
            if(this.priority > givenRule.priority) {
                result = -1;
            }
            else
            {
                result = 1;
            }
        }
        else if(this.weight > givenRule.weight) {
            result = 1;
        }
        else
        {
            result=-1;
        }

        return result;
    }
}

