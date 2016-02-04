package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = {ApplicationConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleEngineTest {

    @Autowired
    RuleRepository ruleRepository;

    @Before
    public void setup(){
        ruleRepository.deleteAll();
    }

    @Test
    public void shouldSaveGivenRule(){
        Date date=new Date();
        RuleEngine ruleEngine = new RuleEngine(ruleRepository);
        Request request=new Request("1","/nisha",date,18,"F","Bangalore");
        ruleEngine.addRule(request.age+">30","/saree.html");
        ruleEngine.addRule(request.age+"<20","/kurta.html");
        ResponseUrl responseUrl = ruleEngine.conditionEvaluate();
        Rule expected=new Rule(request.age+"<20","/kurta.html");



        // Assert.assertEquals("/kurta.html",responseUrl.outputPath);
        Assert.assertEquals(expected,responseUrl.matchedRule);


    }




}
