package com;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@ContextConfiguration(classes = {ApplicationConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleRepositoryTest {

    int count = 0;

    @Autowired
    RuleRepository ruleRepository;

    @Before
    public void setup(){
        ruleRepository.deleteAll();
    }

    @Test
    public void shouldFindAllRules() {
        ruleRepository.save(new Rule("${age}>30", "/xyz.html"));
        ruleRepository.save(new Rule("${city}==abc", "/xyz.html"));
        List<Rule> rules = ruleRepository.findAll();
        assertEquals(2, rules.size());
    }
}
