package com;

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
    GetRuleVariableValue getRuleVariableValue;
    @Autowired
    RuleEngineService ruleEngineService1;
    @Autowired
    RuleParser ruleParser;
    @Autowired
    RuleEvaluator ruleEvaluator;
    @Autowired
    GetRule getRule;
    @Autowired
    ResponseGenerator responseGenerator;

    @Before
    public void setup(){
        ruleRepository.deleteAll();
    }

    @Test
    public void shouldSaveGivenRule(){
        RuleEngineService ruleEngineService = new RuleEngineService(ruleRepository, getRuleVariableValue, ruleParser, ruleEvaluator, getRule,responseGenerator);
        Request request=new Request("/abc",18,"F","Delhi");
        ruleEngineService.addParsedRule("WHEN {city}.equalsIgnoreCase('Blore') WEIGHT0.5 AND {age}>10 WEIGHT0.5 THEN/kurta.html PRIORITY1");
        ruleEngineService.addParsedRule("WHEN {city}.equalsIgnoreCase('DELHi') WEIGHT0.5 AND {age}>10 WEIGHT0.5 THEN/saree.html PRIORITY2");
        ruleEngineService.addParsedRule("WHEN {city}.equalsIgnoreCase('DELHi') WEIGHT0.5 AND {age}>10 WEIGHT0.5 THEN/legging.html PRIORITY12");
        ResponseUrl responseUrl = ruleEngineService.evaluateRule(request);
        String actual = responseUrl.outputPath;
        Assert.assertEquals("/saree.html",actual);
    }
    //Need to write an integretion test for shouldEvaluateRules.
}
