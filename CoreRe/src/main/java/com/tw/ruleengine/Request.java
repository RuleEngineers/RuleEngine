package com.tw.ruleengine;

public class Request {

    private String path;
    private Integer age;
    private String gender;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Request(String path, Integer age, String gender, String city)
    {
        this.path = path;
        this.age = age;
        this.gender = gender;
        this.city = city;
    }
}
