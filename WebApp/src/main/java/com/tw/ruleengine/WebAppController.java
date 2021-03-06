package com.tw.ruleengine;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tw.ruleengine.Request;
import com.tw.ruleengine.service.RuleEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.lang.reflect.Type;
import java.util.Map;

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


    @RequestMapping(value = {"/res"}, method = RequestMethod.GET)
    public @ResponseBody ModelAndView returnRes(@RequestParam Map<String,String> allRequestParams, ModelMap model) {
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, String>>() {}.getType();
        String json = gson.toJson(allRequestParams, mapType);
        Request request = gson.fromJson(json,Request.class);
        String path= ruleEngineService.evaluateRule(request).getOutputPath();
        path="http://localhost"+path;
        return new ModelAndView("redirect:" + path);
    }
}
