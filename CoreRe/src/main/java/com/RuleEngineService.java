package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleEngineService {


    private RuleRepository ruleRepository;
    private GetRuleVariableValue getRuleVariableValue;
    private RuleParser ruleParser;
    private RuleEvaluator ruleEvaluator;
    private GetRule getRule;
    private ResponseGenerator responseGenerator;

    @Autowired
    public RuleEngineService(RuleRepository ruleRepository, GetRuleVariableValue getRuleVariableValue, RuleParser ruleParser, RuleEvaluator ruleEvaluator, GetRule getRule, ResponseGenerator responseGenerator) {
        this.ruleRepository = ruleRepository;
        this.getRuleVariableValue = getRuleVariableValue;
        this.ruleParser = ruleParser;
        this.ruleEvaluator = ruleEvaluator;
        this.getRule = getRule;
        this.responseGenerator = responseGenerator;
    }


    public void addRule(String condition, String outputUrl, Integer priority,Double weight) {
        ruleRepository.save(new Rule(condition, outputUrl, priority, weight));
    }

    public void addParsedRule(String ruleString)
    {
        String ruleCondition = ruleParser.parseRule(ruleString);
        Rule rule = getRule.getParsedRule(ruleCondition);
        addRule(rule.condition, rule.outputPath, rule.priority, 0.0);
    }


    public void deleteRule(String ruleId) {
        ruleRepository.deleteByRuleId(ruleId);
        return;
    }


    public ResponseUrl evaluateRule(Request req) {
        try {
            List<Rule> rules = ruleRepository.findAll();
            for (Rule rule : rules) {
                rule.condition = getRuleVariableValue.findRuleValue(req, rule);
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


