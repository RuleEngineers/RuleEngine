package com.tw.ruleengine.repository;


import com.tw.ruleengine.Rule;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository extends MongoRepository<Rule,String> {

//    public Request findByAgeAndGender(Integer age, String gender);
//    public Request findByPathAndReqId(String path, String ruleId);
//    public List<Request> findByAgeBetween(Integer lowAge, Integer highAge);
//    public List<Request> findByAgeGreaterThan(Integer age);
//    public List<Request> findByAgeLowerThan(Integer age);
    //public List<Rule> sortByPriority(List<Rule> rules);
    //public List<Rule> findAll(Sort sort);
    public String deleteByRuleId(String ruleId);
    List<Rule> findAll(Sort sort);


}


