package com.tw.ruleengine.recommend.repository;

import com.tw.ruleengine.recommend.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Users,String> {

}
