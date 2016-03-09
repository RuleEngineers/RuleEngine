package com;

import groovy.util.Eval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.ws.Response;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RuleEngineService {


    private RuleRepository ruleRepository;
    private RuleOperations ruleOperations;

    @Autowired
    public RuleEngineService(RuleRepository ruleRepository, RuleOperations ruleOperations) {
        this.ruleRepository = ruleRepository;
        this.ruleOperations = ruleOperations;
    }


    public void addRule(String condition, String outputUrl, Integer priority) {
        ruleRepository.save(new Rule(condition, outputUrl, priority));
    }


    public void deleteRule(String ruleId) {
        ruleRepository.deleteByRuleId(ruleId);
        return;
    }


    public ResponseUrl conditionEvaluate(Request req) {
        try {

            List<Rule> rules = ruleRepository.findAll(new Sort(Sort.Direction.ASC, "priority"));
            for (Rule rule : rules) {
                System.out.println(rule);
                rule.condition = ruleOperations.findRuleValue(req, rule);

                Boolean result = evaluate(rule);
                if (result.equals(true)) {
                    return new ResponseUrl(rule.outputPath);
                }
            }
        } catch (Exception e) {
        }
        return new ResponseUrl("/default.html");
    }

    private Boolean evaluate(Rule rule) {
        if ((Boolean) (Eval.me(rule.condition)).equals(true)) {
            return true;
        }
        return false;
    }


    public List<Rule> listRules() {
        return ruleRepository.findAll();
    }
}


