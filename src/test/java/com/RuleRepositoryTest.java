package com;

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
    MongoOperations mongoOperations;


    @Test
    public void shouldFindAllRules() {
        Date date = new Date();
        //mongoOperations.saveDocs(new Rule("1","Uniform",date, 8,"F", "Bangalore"));



        List<Rule> rules = mongoOperations.findDocs();

        //Rule rul = mongoOperations.queryAgeGender();
        //Rule rul = mongoOperations.queryPathRuleId();
        List<Rule> rul = mongoOperations.queryAgeGreater();

        /*for (Rule rules : ruleRepository.findAll()) {
            count++;
       }


        assertEquals(1, count);
        List<Rule> rules = ruleRepository.findAll();
        for(Rule rule : rules) {
            assertEquals("123", rule.ruleId);
        }*/

        assertEquals(7, rul.size());

        //assertEquals("Bangalore", rul.city);
    }
}
