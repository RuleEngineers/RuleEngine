package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class RuleEngineController {

    private RuleEngineService ruleEngineService;

    public RuleEngineController() {}

    @Autowired
    public RuleEngineController(RuleEngineService ruleEngineService) {
        this.ruleEngineService = ruleEngineService;
    }

    @RequestMapping(value = "/rule", method = RequestMethod.POST)
    public String addRule(@RequestBody Rule rule) {
        System.out.printf("Inside controller..");
        ruleEngineService.addRule(rule.condition, rule.outputPath);
        return "success";
    }

}
