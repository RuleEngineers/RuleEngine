package com.tw.ruleengine.components;

import com.tw.ruleengine.Request;
import com.tw.ruleengine.Rule;
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
            Matcher regexMatcher = regex.matcher(rule.getCondition());
            while (regexMatcher.find()) {
                rulewithvariable.add(regexMatcher.group(1));
            }
            Object reqAttributeValue[] = new Object[rulewithvariable.size()];
            rule.setCondition(findAttributeValue(rule, req,reqAttributeValue));

        rulewithvariable.clear();
        param.clear();
        return rule.getCondition();
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
                        f1.setAccessible(true);
                        reqAttributeValue[next] = f1.get(req);
                        break;
                    }
                }

                rule.setCondition(replaceAttributeValue(reqAttributeValue[next], rule,next));
                next++;
            }

        }
        catch(Exception e)
        {
        }
        return rule.getCondition();
    }

    private String replaceAttributeValue(Object reqAttributeValue, Rule rule,int next) {
        for (String variable : rulewithvariable) {


            if (reqAttributeValue instanceof String) {

                rule.setCondition(rule.getCondition().replace("{" + rulewithvariable.get(next) + "}", "\'" + reqAttributeValue.toString() + "\'"));

            } else {
                rule.setCondition(rule.getCondition().replace("{" + rulewithvariable.get(next) + "}", reqAttributeValue.toString()));

            }

        }
        return rule.getCondition();
    }

}




