package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        RuleEngine ruleEngine = new RuleEngine(ruleRepository);
        //Rule expectedRule = new Rule("10 >= 20","/sample.html");
        ruleEngine.addRule("80 >= 20","/sample1.html");
        ruleEngine.addRule("5 >= 20","/sample2.html");
        ruleEngine.addRule("70 >= 20","/sample3.html");
        ruleEngine.addRule("15 >= 20","/sample4.html");

//        List<Boolean> list  = ruleEngine.conditionEvaluate();
//
//        for(Boolean lists : list){
//        Assert.assertFalse(lists);
//        }
//        //List<Rule> rules = ruleRepository.findAll();
        //Assert.assertEquals(expectedRule, rules.get(0));

        ResponseUrl responseUrl = ruleEngine.conditionEvaluate();
        Assert.assertEquals("/sample3.html",responseUrl.outputPath);


    }




}
