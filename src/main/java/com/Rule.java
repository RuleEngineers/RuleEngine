package com;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rules")
public class Rule {

    @Id
    String ruleId;

    public Rule(String ruleId) {
        this.ruleId = ruleId;
    }
}
