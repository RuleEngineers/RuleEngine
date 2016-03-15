package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/api")
@EnableWebMvc
public class CoreController {

    //private RuleParsingService ruleParsingService;

    public CoreController() {
    }

    //@Autowired
    //public CoreController(RuleParsingService ruleParsingService) {
        //this.ruleParsingService = ruleParsingService;
    //}

//    @RequestMapping(value = "/enterRule1", method = RequestMethod.POST)
//    @ResponseBody
//    public String addRule(@RequestBody String string) {
//        System.out.println("in post");
//        ruleParsingService.parseRule(string);
//        return "success";
//    }

    @RequestMapping(value = "/enterRule", method = RequestMethod.POST)
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter pw = res.getWriter();
        String result = req.getParameter("result");
        System.out.println(result);
       // ruleParsingService.parseRule(result);
        res.setContentType("text/html");
        pw.println("<h2>Rule added....</h2>");
        pw.close();
    }
}
