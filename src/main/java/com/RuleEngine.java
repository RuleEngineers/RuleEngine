package com;

import groovy.util.Eval;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {

    private RuleRepository ruleRepository;

    @Autowired
    public RuleEngine(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public void addRule(String condition, String outputUrl) {
        ruleRepository.save(new Rule(condition, outputUrl));
    }


    public List<Boolean> conditionEvaluate() {
        List<Rule> rules = ruleRepository.findAll();
        List<Boolean> list  = new ArrayList();


        for(Rule rule:rules) {
            list.add((Boolean) (Eval.me(rule.condition)));
        }

        return list;

    }

}
