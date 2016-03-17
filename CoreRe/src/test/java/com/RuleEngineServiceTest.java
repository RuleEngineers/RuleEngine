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
    RuleOperations ruleOperations;
    @Autowired
    RuleEngineService ruleEngineService1;

    @Before
    public void setup(){
        ruleRepository.deleteAll();
    }

    /*@Test
    public void shouldSaveGivenRule(){
        RuleEngineService ruleEngineService = new RuleEngineService(ruleRepository,ruleOperations);
        Request request=new Request("/abc",18,"F","Delhi");
        ruleEngineService.addRule("{age}>15 && {age}>10","/kurta.html",2);
        ruleEngineService.addRule("{city}.equalsIgnoreCase('DELHi') && {age}>10","/saree.html",1);
        ResponseUrl responseUrl = ruleEngineService.conditionEvaluate(request);
        Assert.assertEquals("/saree.html",responseUrl.outputPath);
    }*/

    @Test
    public  void shouldParseRule(){
        RuleParsingService ruleParsingService = new RuleParsingService(ruleEngineService1);
        String answer = ruleParsingService.parseRule("WHEN {age}ISEQUALS3 THEN g.html");
        Assert.assertEquals("success",answer);
    }


    /*@Test
    public void shouldEvaluateRules(){
        RuleEngineService ruleEngineService = new RuleEngineService(ruleRepository);
        ruleEngineService.addRule("{age}>10", "/kurta.html");
        ruleEngineService.addRule("{age}<10", "/saree.html");
        ruleEngineService.addRule("{age}<10 && {city}.equals('xyz')", "/abc.html");
        ruleEngineService.addRule("{city}.equals('delhi')", "/xyz.html");

        Request request1 = new Request("", 10, "", "delhi");
        Request request2 = new Request("", 40, "", "abc");
        Assert.assertEquals("/xyz.html", ruleEngineService.conditionEvaluate(request1).outputPath);
        Assert.assertEquals("/kurta.html", ruleEngineService.conditionEvaluate(request2).outputPath);
    }*/
}
