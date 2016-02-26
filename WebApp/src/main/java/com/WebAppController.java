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



    @RequestMapping(value = "/res/{req}", method = RequestMethod.GET)
    public @ResponseBody ModelAndView returnRes(@PathVariable Request req){
        String path= ruleEngineService.conditionEvaluate(req).outputPath;
        return new ModelAndView("redirect:localhost" + path);


    }



}
