package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

@ContextConfiguration(classes = {ApplicationConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleEngineServiceTest {

    @Autowired
    RuleRepository ruleRepository;

    @Before
    public void setup(){
        ruleRepository.deleteAll();
    }

    @Test
    public void shouldSaveGivenRule(){
        String id = new String("");
        Date date=new Date();
        Date date1 = new Date(94, 12, 16);
        Date date2 = new Date(94, 03, 16);
        RuleEngineService ruleEngineService = new RuleEngineService(ruleRepository);
        Request request=new Request("1","/abc",date,18,"F","Delhi");
        ruleEngineService.addRule("{age}>15 && {age}<10","/saree.html");
       // ruleEngineService.addRule("{age}<30 || {age}<10","/dress.html");
        //ruleEngineService.addRule("{age}>35","/dupatta.html");
       // ruleEngineService.addRule("{city}(!=)Delhi","/clothes.html");
        ruleEngineService.addRule("{city}.equalsIgnoreCase('DELHi') && {age}>10","/saree.html");

        //ruleEngineService.addRule("city; == ;Bangalore","/saree.html");
       // "{city}.equals('Banglore')&&{age}>30"
      //  ruleEngineService.addRule(request.age+"<20"+ "&&" +request.age+"<30","/kurta.html");

        //ruleEngineService.addRule(request.date+ ";" +date1+ ";" +date2,"/season.html");





       ResponseUrl responseUrl = ruleEngineService.conditionEvaluate(request);
        //Rule expected=new Rule(request.age+"<20","/kurta.html");
        //ResponseUrl responseUrl = ruleEngineService.dateEvaluate();



         Assert.assertEquals("/saree.html",responseUrl.outputPath);
        //Assert.assertEquals(expected,responseUrl.matchedRule);
//        List<Rule> rules = ruleRepository.findAll();
//        for(Rule rule : rules){
//            id = rule.ruleId;
//        }
//        ruleEngineService.deleteRule(id);
//        List<Rule> Rules = ruleRepository.findAll();
//        assertEquals(1, Rules.size());
        //Assert.assertEquals("");


    }




}
