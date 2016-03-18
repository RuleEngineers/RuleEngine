package com;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class GetRuleVariableValue implements IRuleInterface {

    private List<String> rulewithvariable = new ArrayList<String>();
    private List<String> param = new ArrayList<String>();

    public String findRuleValue(Request req, Rule rule) {

            Pattern regex = Pattern.compile("\\{(.*?)\\}");
            Matcher regexMatcher = regex.matcher(rule.condition);
            while (regexMatcher.find()) {
                rulewithvariable.add(regexMatcher.group(1));
            }
            Object reqAttributeValue[] = new Object[rulewithvariable.size()];
            rule.condition = findAttributeValue(rule, req,reqAttributeValue);

        rulewithvariable.clear();
        param.clear();
        return rule.condition;
}


    private String findAttributeValue(Rule rule, Request req,Object[] reqAttributeValue) {
        int next=0;

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

                rule.condition = replaceAttributeValue(reqAttributeValue[next], rule,next);
                next++;
            }

        }
        catch(Exception e)
        {
        }
        return rule.condition;
    }

    private String replaceAttributeValue(Object reqAttributeValue, Rule rule,int next) {
        for (String variable : rulewithvariable) {


            if (reqAttributeValue instanceof String) {

                rule.condition = rule.condition.replace("{" + rulewithvariable.get(next) + "}", "\'" + reqAttributeValue.toString() + "\'");

            } else {
                rule.condition = rule.condition.replace("{" + rulewithvariable.get(next) + "}", reqAttributeValue.toString());

            }

        }
        return rule.condition;
    }

}




