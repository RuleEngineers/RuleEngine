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

    //To add and save a new rule
    public void addRule(String condition, String outputUrl) {
        ruleRepository.save(new Rule(condition, outputUrl));
    }

    //To delete rule
    public void deleteRule(String ruleId) {
        ruleRepository.deleteByRuleId(ruleId);
        return;
    }

    //Evaluates Condition of rule saved
    public ResponseUrl conditionEvaluate(Request req) {
        try {

            List<Rule> rules = ruleRepository.findAll();
            
            //Iterates through all the saved rules
            for (Rule rule : rules) {
                int i = 0;

                List<String> rulewithvariable = new ArrayList<String>();//find variables to be replaced
                List<String> param = new ArrayList<String>();//find the actual object attribute to be replaced

                //Pattern Matching for the variable to be replaced
                Pattern regex = Pattern.compile("\\{(.*?)\\}");
                Matcher regexMatcher = regex.matcher(rule.condition);
                while (regexMatcher.find()) {
                    rulewithvariable.add(regexMatcher.group(1));
                }

                //To store the request attribute values
                Object reqAttributeValue[] = new Object[rulewithvariable.size()];

                //Actual Replacement
                for (String str : rulewithvariable) {

                    //Find value of the attribute
                    for (Field f : req.getClass().getDeclaredFields()) {

                        if (rulewithvariable.get(i).equals(f.getName())) {
                            param.add(rulewithvariable.get(i));
                            Class request1 = req.getClass();
                            Field f1 = request1.getDeclaredField(param.get(i));
                            reqAttributeValue[i] = f1.get(req);
                            break;
                        }
                    }

                    //Replace value of the attribute in the condition
                    for (String str1 : rulewithvariable) {

                        //Escaping the string for eval.me
                        if (reqAttributeValue[i] instanceof String) {

                            rule.condition = rule.condition.replace("{" + rulewithvariable.get(i) + "}", "\'" + reqAttributeValue[i].toString() + "\'");

                        } else {
                            rule.condition = rule.condition.replace("{" + rulewithvariable.get(i) + "}", reqAttributeValue[i].toString());

                        }

                    }
                    //System.out.println(rule.condition);

                    i++;
                }

                System.out.println(rule.condition);
                //Evaluation of the rule
                if ((Boolean) (Eval.me(rule.condition)).equals(true)) {
                    return new ResponseUrl(rule.outputPath);
                }


            }

        } catch (Exception e) {

        }
        return new ResponseUrl("/default.html");

    }
    public List<Rule> listRules() {
        return ruleRepository.findAll();
    }
}

