package com;

import groovy.util.Eval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
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

    @Autowired
    public RuleEngineService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;

    }


    public void addRule(String condition, String outputUrl) {
        ruleRepository.save(new Rule(condition, outputUrl));
    }


    public void deleteRule(String ruleId) {
        ruleRepository.deleteByRuleId(ruleId);
        return;
    }


    public ResponseUrl conditionEvaluate(Request req) {
        try {

            List<Rule> rules = ruleRepository.findAll();
            for (Rule rule : rules) {
                int next = 0;
                List<String> rulewithvariable = new ArrayList<String>();
                List<String> param = new ArrayList<String>();
                rulewithvariable = matchRuleVariable(rule,rulewithvariable);
                Object reqAttributeValue[] = new Object[rulewithvariable.size()];
                reqAttributeValue = findAttributeValue(rulewithvariable, reqAttributeValue, param, req, rule, next);
                Boolean result = evaluate(rule);
                if (result.equals(true)) {
                    return new ResponseUrl(rule.outputPath);
                }
            }
        }catch (Exception e) {
        }
        return new ResponseUrl("/default.html");
    }

    private List<String> matchRuleVariable(Rule rule, List<String> rulewithvariable) {
        //Pattern Matching for the variable to be replaced
        Pattern regex = Pattern.compile("\\{(.*?)\\}");
        Matcher regexMatcher = regex.matcher(rule.condition);
        while (regexMatcher.find()) {
            rulewithvariable.add(regexMatcher.group(1));
        }
        return rulewithvariable;
    }

    private Object[] findAttributeValue(List<String> rulewithvariable, Object[] reqAttributeValue, List<String> param, Request req, Rule rule, int next) {

        try {
            for (String str : rulewithvariable) {


                for (Field f : req.getClass().getDeclaredFields()) {

                    if (rulewithvariable.get(next).equals(f.getName())) {
                        param.add(rulewithvariable.get(next));
                        Class request1 = req.getClass();
                        Field f1 = request1.getDeclaredField(param.get(next));
                        reqAttributeValue[next] = f1.get(req);
                        break;
                    }
                }

                rule.condition = replaceAttributeValue(rulewithvariable, reqAttributeValue, rule, next);


                next++;
            }

        }
        catch(Exception e)
        {
    }
    return reqAttributeValue;
}


    private String replaceAttributeValue(List<String> rulewithvariable, Object[] reqAttributeValue, Rule rule,int next) {

        for (String variable : rulewithvariable) {


            if (reqAttributeValue[next] instanceof String) {

                rule.condition = rule.condition.replace("{" + rulewithvariable.get(next) + "}", "\'" + reqAttributeValue[next].toString() + "\'");

            } else {
                rule.condition = rule.condition.replace("{" + rulewithvariable.get(next) + "}", reqAttributeValue[next].toString());

            }

        }
        return rule.condition;
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

