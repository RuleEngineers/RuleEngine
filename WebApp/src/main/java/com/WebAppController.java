package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@RequestMapping("/api")
@EnableWebMvc
public class WebAppController {

    private RuleEngineService ruleEngineService;

    public WebAppController() {}

    @Autowired
    public WebAppController(RuleEngineService ruleEngineService) {
        this.ruleEngineService = ruleEngineService;
    }

//    @RequestMapping(value = "/res", method = RequestMethod.POST)
//    public String addRule(@RequestBody Rule rule) {
//        System.out.printf("Inside controller..");
//        ruleEngineService.addRule(rule.condition, rule.outputPath);
//        return "success";
//    }
//
//    @RequestMapping(value = "/rule/{id}", method = RequestMethod.DELETE)
//    public String deleteRule(@PathVariable String id) {
//        ruleEngineService.deleteRule(id);
//        return "deleted";
//
//    }

    @RequestMapping(value = "/res", method = RequestMethod.GET)
    public @ResponseBody ModelAndView returnRes(){
        String path= ruleEngineService.conditionEvaluate().outputPath;
        //String redirectUrl = path;
        //return "redirect:" + redirectUrl;
        return new ModelAndView("redirect:localhost" + path);


    }



}
