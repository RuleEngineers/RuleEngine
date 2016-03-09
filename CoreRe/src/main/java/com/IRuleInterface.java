package com;

import org.springframework.stereotype.Component;

@Component
public interface IRuleInterface {

  public String findRuleValue(Request req,Rule rule);
}
