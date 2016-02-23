package com;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rules")
public class Rule {

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

    @Id
    String ruleId;

    String condition;
    String outputPath;

    public Rule() {

    }

    public Rule(String condition, String outputPath) {
        this.condition = condition;
        this.outputPath = outputPath;
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
}

