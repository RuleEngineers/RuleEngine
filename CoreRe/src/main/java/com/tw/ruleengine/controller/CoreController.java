package com.tw.ruleengine.controller;

import com.tw.ruleengine.service.RuleEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/api")
@EnableWebMvc
public class CoreController {

    private RuleEngineService ruleEngineService;

    @Autowired
    public CoreController(RuleEngineService ruleEngineService) {

        this.ruleEngineService = ruleEngineService;
    }

    //@CrossOrigin(origins = "*")
    @RequestMapping(value = "/enterRule", method = RequestMethod.POST)
    @ResponseBody
    public void enterRule(@RequestBody String result) {

        ruleEngineService.addParsedRule(result);
    }
}
