package com;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ResponseGenerator {

    public ResponseUrl getResponse(List<Rule> rules) {
        Collections.sort(rules);
        int size = rules.size();
        return  new ResponseUrl(rules.get(size-1).outputPath);
    }
}
