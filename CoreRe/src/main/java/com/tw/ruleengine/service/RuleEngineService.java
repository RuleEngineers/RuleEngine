package com.tw.ruleengine.service;

import com.tw.ruleengine.Request;
import com.tw.ruleengine.ResponseUrl;
import com.tw.ruleengine.Rule;
import com.tw.ruleengine.components.*;
import com.tw.ruleengine.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleEngineService {

    private RuleRepository ruleRepository;
    private RuleVariableValue ruleVariableValue;
    private RuleParser ruleParser;
    private RuleEvaluator ruleEvaluator;
    private RuleGenerator ruleGenerator;
    private ResponseGenerator responseGenerator;

    @Autowired
    public RuleEngineService(RuleRepository ruleRepository, RuleVariableValue ruleVariableValue, RuleParser ruleParser, RuleEvaluator ruleEvaluator, RuleGenerator ruleGenerator, ResponseGenerator responseGenerator) {
        this.ruleRepository = ruleRepository;
        this.ruleVariableValue = ruleVariableValue;
        this.ruleParser = ruleParser;
        this.ruleEvaluator = ruleEvaluator;
        this.ruleGenerator = ruleGenerator;
        this.responseGenerator = responseGenerator;
    }

    private void addRule(String condition, String outputUrl, Integer priority,Double weight) {
        ruleRepository.save(new Rule(condition, outputUrl, priority, weight));
    }

    public void addParsedRule(String ruleString)
    {
        String ruleCondition = ruleParser.parseRule(ruleString);
        Rule rule = ruleGenerator.getParsedRule(ruleCondition);
        addRule(rule.getCondition(), rule.getOutputPath(), rule.getPriority(), 0.0);
    }


    public void deleteRule(String ruleId) {
        ruleRepository.deleteByRuleId(ruleId);
        return;
    }

    public ResponseUrl evaluateRule(Request req) {
        try {
            List<Rule> rules = ruleRepository.findAll();
            for (Rule rule : rules) {
                rule.setCondition(ruleVariableValue.findRuleValue(req, rule));
                System.out.println("rc"+rule.getCondition());
                rule = ruleEvaluator.ruleEvaluate(rule);
            }
            ResponseUrl response = responseGenerator.getResponse(rules);
            return response;
        }
        catch (Exception e) {
        }
        return new ResponseUrl("/default.html");
    }

    public List<Rule> listRules() {

        return ruleRepository.findAll();
    }
}