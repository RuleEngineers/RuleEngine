package com;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@ContextConfiguration(classes = {ApplicationConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleRepositoryTest {

    int count = 0;

    @Autowired
    RuleRepository ruleRepository;


    @Test
    public void shouldFindAllRules() {
        ruleRepository.save(new Rule("123"));

        for (Rule rules : ruleRepository.findAll()) {
            count++;
        }


        assertEquals(1, count);
        List<Rule> rules = ruleRepository.findAll();
        for(Rule rule : rules) {
            assertEquals("123", rule.ruleId);
        }

        assertEquals(1, rules.size());
    }
}
