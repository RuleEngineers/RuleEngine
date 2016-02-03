package com;

import org.springframework.beans.factory.annotation.Autowired;

public class RuleEngine {

    private RuleRepository ruleRepository;

    @Autowired
    public RuleEngine(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public void addRule(String condition, String outputUrl) {
        ruleRepository.save(new Rule(condition, outputUrl));
    }
}
