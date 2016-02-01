package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoOperations {

    private RuleRepository ruleRepository;

    @Autowired
    public MongoOperations(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public void saveDocs(Rule rule) {
        ruleRepository.save(rule);
    }

    public List<Rule> findDocs(){
        return ruleRepository.findAll();
    }

    public Rule queryAgeGender(){
        return ruleRepository.findByAgeAndGender(18,"F");
    }

    public Rule queryPathRuleId(){
        return ruleRepository.findByPathAndRuleId("Jeans","6");
    }

    public List<Rule> queryAgeLower(){
        return ruleRepository.findByAgeLowerThan(40);
    }

    public List<Rule> queryAgeGreater(){
        return ruleRepository.findByAgeGreaterThan(20);
    }

    public List<Rule> queryAgeBetween(){
        return ruleRepository.findByAgeBetween(15,40);
    }







}
