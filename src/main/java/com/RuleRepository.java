package com;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository extends MongoRepository<Rule,String> {

    public Rule findByAgeAndGender(Integer age, String gender);
    public Rule findByPathAndRuleId(String path, String ruleId);
    public List<Rule> findByAgeBetween(Integer lowAge, Integer highAge);
    public List<Rule> findByAgeGreaterThan(Integer age);
    public List<Rule> findByAgeLowerThan(Integer age);


}


