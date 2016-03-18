package com.tw.ruleengine;

import com.tw.ruleengine.service.RuleEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/api")
@EnableWebMvc
public class RuleEngineController {

    private RuleEngineService ruleEngineService;

    public RuleEngineController() {}

    @Autowired
    public RuleEngineController(RuleEngineService ruleEngineService) {
        this.ruleEngineService = ruleEngineService;
    }

    @RequestMapping(value = "/rule", method = RequestMethod.POST)
    @ResponseBody
    public String addRule(@RequestBody Rule rule) {
        System.out.println("in post");
        ruleEngineService.addRule(rule.getCondition, rule.outputPath,1,0.0);
       return "success";
    }

    @RequestMapping(value = "/rule/{id}", method = RequestMethod.DELETE)
    public String deleteRule(@PathVariable String id) {
        ruleEngineService.deleteRule(id);
        return "deleted";
    }

    @RequestMapping(value = "/rule", method = RequestMethod.GET)
    public @ResponseBody List<Rule> listRule(){

        return ruleEngineService.listRules();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
    {

        PrintWriter pw = res.getWriter();
        String name = req.getParameter("usr");
        String pwd = req.getParameter("pwd");
        res.setContentType("text/html");
        if(name == null|| name.equals("")||pwd == null || pwd.equals(""))
        {
            pw.println("<h2>Sorry..Could not log you in. Will redirect to main login page.Please wait</h2>");
            res.setHeader("Refresh","5;http://localhost/login.html");
        }
        else
        {
            pw.println("<h2>WELCOME  "+ name+"   Please Enter Rules. We will redirect you to the page...</h2>");
            res.setHeader("Refresh","2;http://localhost/EnterRule.html");
        }

        pw.close();

    }
}
