package com.tw.ruleengine.components;

import com.tw.ruleengine.Request;
import com.tw.ruleengine.Rule;
import org.springframework.stereotype.Component;

@Component
public interface IRuleInterface {
  public String findRuleValue(Request req, Rule rule);
}
