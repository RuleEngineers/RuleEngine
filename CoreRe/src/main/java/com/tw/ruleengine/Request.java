package com.tw.ruleengine;

public class Request {

    String path;
     Integer age;
     String gender;
     String city;

    public Request(String path, Integer age, String gender, String city)
    {
        this.path = path;
        this.age = age;
        this.gender = gender;
        this.city = city;
    }
}
