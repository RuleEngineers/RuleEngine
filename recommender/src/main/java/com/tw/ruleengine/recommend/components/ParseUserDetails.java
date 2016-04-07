package com.tw.ruleengine.recommend.components;

import com.tw.ruleengine.recommend.Users;
import org.springframework.stereotype.Component;


@Component
public class ParseUserDetails {
    public Users parse(String details)
    {
        String[] userDetails=details.split(";");
        String name=userDetails[0];
        String emailId=userDetails[1];
        String userId=userDetails[2];
        String password=userDetails[3];
        Users user=new Users(name,emailId,userId,password);
        return user;
    }

    public String parseUserId(String details) {
        String userLoginDetails[]=details.split(";");
        return userLoginDetails[0];
    }

    public String parsePassword(String details) {
        String userLoginDetails[]=details.split(";");
        return userLoginDetails[1];
    }
}
