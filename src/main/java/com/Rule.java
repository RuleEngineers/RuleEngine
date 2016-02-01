package com;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "rules")
public class Rule {

    @Id
    String ruleId;


    String path;
     Date date;
     Integer age;
     String gender;
     String city;

    public Rule(String ruleId, String path, Date date, Integer age, String gender, String city)
    {
        this.ruleId = ruleId;
        this.path = path;
        this.date = date;
        this.age = age;
        this.gender = gender;
        this.city = city;
    }
}
