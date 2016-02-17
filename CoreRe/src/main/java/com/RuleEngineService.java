package com;

import groovy.util.Eval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@Component
public class RuleEngineService {


    private RuleRepository ruleRepository;

    @Autowired
    public RuleEngineService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;

    }

    public void addRule(String condition, String outputUrl) {
        ruleRepository.save(new Rule(condition, outputUrl));
    }


    public ResponseUrl conditionEvaluate() {
        List<Rule> rules = ruleRepository.findAll();



        for (Rule rule : rules) {
            if ((Boolean) (Eval.me(rule.condition)).equals(true)) {
                return new ResponseUrl(rule.outputPath, rule);

            }
        }
        return null;

    }


    public ResponseUrl dateEvaluate() {

        List<Rule> rules = ruleRepository.findAll();
        for (Rule rule : rules) {
            String[] dates = rule.condition.split(";");
            //String reqDate = dates[0].parse
//            if() {
//                return new ResponseUrl(rule.outputPath, rule);
//
//            }
        }
        return null;

    }
}
