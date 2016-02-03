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
        Rule expectedRule = new Rule("${sample}","/sample.html");
        ruleEngine.addRule("${sample}","/sample.html");
        List<Rule> rules = ruleRepository.findAll();
        Assert.assertEquals(expectedRule, rules.get(0));
    }
}
