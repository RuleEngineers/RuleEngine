package com.tw.ruleengine.components;

import com.tw.ruleengine.Rule;
import groovy.util.Eval;
import org.springframework.stereotype.Component;

@Component
public class RuleEvaluator {

    public Rule ruleEvaluate(Rule rule)
    {
        return getConditions(rule);
    }

    private Rule getConditions(Rule rule)
    {
        String conditions[] = rule.getCondition().split("&");
        Double weight = 0.0;

        for(String condition:conditions)
        {
            String singleCondition[] = condition.split(",");
            Boolean eval = evaluate(singleCondition[0]);

            if(eval.equals(true))
            {
                weight += Double.parseDouble(singleCondition[1]);
            }
        }
        rule.setWeight(weight);
        return rule;
    }

    private Boolean evaluate(String condition) {
        if ((Boolean) (Eval.me(condition)).equals(true)) {
            return true;
        }
        return false;
    }

}
