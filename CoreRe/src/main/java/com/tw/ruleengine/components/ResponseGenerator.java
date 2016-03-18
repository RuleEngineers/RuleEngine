package com.tw.ruleengine.components;

import com.tw.ruleengine.ResponseUrl;
import com.tw.ruleengine.Rule;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ResponseGenerator {

    public ResponseUrl getResponse(List<Rule> rules) {
        Collections.sort(rules);
        int size = rules.size();
        return  new ResponseUrl(rules.get(size-1).getOutputPath());
    }
}
