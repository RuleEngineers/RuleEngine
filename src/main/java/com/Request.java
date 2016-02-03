package com;

import java.util.Date;

public class Request {

    String reqId;
    String path;
     Date date;
     Integer age;
     String gender;
     String city;

    public Request(String reqId, String path, Date date, Integer age, String gender, String city)
    {
        this.reqId = reqId;
        this.path = path;
        this.date = date;
        this.age = age;
        this.gender = gender;
        this.city = city;
    }
}
