package com.tw.ruleengine.recommend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoOperations {

    private MovieRepository movieRepository;

    @Autowired
    public MongoOperations(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

//    public void saveDocs(Request request) {
//        movieRepository.save(request);
//    }
//
//    public List<Request> findDocs(){
//        return movieRepository.findAll();
//    }
//
//    public Request queryAgeGender(){
//        return movieRepository.findByAgeAndGender(18,"F");
//    }
//
//    public Request queryPathReqId(){
//        return movieRepository.findByPathAndReqId("Jeans","6");
//    }

//    public List<Request> queryAgeLower(){
//        return movieRepository.findByAgeLowerThan(40);
//    }
//
//    public List<Request> queryAgeGreater(){
//        return movieRepository.findByAgeGreaterThan(20);
//    }
//
//    public List<Request> queryAgeBetween(){
//        return movieRepository.findByAgeBetween(15,40);
//    }







}
