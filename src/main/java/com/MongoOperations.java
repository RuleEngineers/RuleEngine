package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoOperations {

    private RuleRepository ruleRepository;

    @Autowired
    public MongoOperations(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public void saveDocs(Rule rule) {
        ruleRepository.save(rule);
    }
}
