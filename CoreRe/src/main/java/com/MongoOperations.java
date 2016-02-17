package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoOperations {

    private RuleRepository ruleRepository;

    @Autowired
    public MongoOperations(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

//    public void saveDocs(Request request) {
//        ruleRepository.save(request);
//    }
//
//    public List<Request> findDocs(){
//        return ruleRepository.findAll();
//    }
//
//    public Request queryAgeGender(){
//        return ruleRepository.findByAgeAndGender(18,"F");
//    }
//
//    public Request queryPathReqId(){
//        return ruleRepository.findByPathAndReqId("Jeans","6");
//    }

//    public List<Request> queryAgeLower(){
//        return ruleRepository.findByAgeLowerThan(40);
//    }
//
//    public List<Request> queryAgeGreater(){
//        return ruleRepository.findByAgeGreaterThan(20);
//    }
//
//    public List<Request> queryAgeBetween(){
//        return ruleRepository.findByAgeBetween(15,40);
//    }







}
