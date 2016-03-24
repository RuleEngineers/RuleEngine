package com.tw.ruleengine.service;

import com.tw.ruleengine.Request;
import com.tw.ruleengine.ResponseUrl;
import com.tw.ruleengine.components.*;
import com.tw.ruleengine.controller.WebContextLoader;
import com.tw.ruleengine.repository.RuleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;


//@ContextConfiguration(classes = {ApplicationConfiguration.class})
@ContextConfiguration(loader = WebContextLoader.class, locations = {"file:src/main/webapp/WEB-INF/Core-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
//@PropertySource("classpath:application.properties")
public class RuleEngineServiceTest {

    @Autowired
    RuleRepository ruleRepository;
    @Autowired
    RuleVariableValue ruleVariableValue;
    @Autowired
    RuleParser ruleParser;
    @Autowired
    RuleEvaluator ruleEvaluator;
    @Autowired
    RuleGenerator ruleGenerator;
    @Autowired
    ResponseGenerator responseGenerator;

    @Before
    public void setup(){
        ruleRepository.deleteAll();
    }

    @Test
    public void shouldSaveGivenRule(){
        RuleEngineService ruleEngineService = new RuleEngineService(ruleRepository, ruleVariableValue, ruleParser, ruleEvaluator, ruleGenerator,responseGenerator);
        Request request=new Request("/abc",8,"F","Blore1");
        //ruleEngineService.addParsedRule("WHEN {city}.equalsIgnoreCase('Blore') WEIGHT0.5 AND {age}>10 WEIGHT0.5 THEN/kurta.html PRIORITY1");
        //ruleEngineService.addParsedRule("WHEN {city}.equalsIgnoreCase('DELHi') WEIGHT0.5 AND {age}>10 WEIGHT0.5 THEN/saree.html PRIORITY2");
        //ruleEngineService.addParsedRule("WHEN {city}.equalsIgnoreCase('DELHi') WEIGHT0.5 AND {age}>10 WEIGHT0.5 THEN/legging.html PRIORITY12");
        ruleEngineService.addParsedRule("WHEN {age} ISGREATERTHAN 10 WEIGHT 0.5 AND  {city} ISEQUALS('Blore1') WEIGHT 0.5 THEN/kurta.html PRIORITY1");
        ResponseUrl responseUrl = ruleEngineService.evaluateRule(request);
        System.out.println("ru"+responseUrl);
        String actual = responseUrl.getOutputPath();
        Assert.assertEquals("/saree.html",actual);
    }
    //Need to write an integretion test for shouldEvaluateRules.
}
