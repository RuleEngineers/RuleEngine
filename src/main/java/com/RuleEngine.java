package com;

import groovy.util.Eval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@Component
public class RuleEngine {


    private RuleRepository ruleRepository;

    @Autowired
    public RuleEngine(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;

    }

    public void addRule(String condition, String outputUrl) {
        ruleRepository.save(new Rule(condition, outputUrl));
    }


    public ResponseUrl conditionEvaluate() {
        List<Rule> rules = ruleRepository.findAll();
        //List<Boolean> list  = new ArrayList();


        for (Rule rule : rules) {
            if ((Boolean) (Eval.me(rule.condition)).equals(true)) {
                return new ResponseUrl(rule.outputPath, rule);

            }
        }
        return null;

    }


}
