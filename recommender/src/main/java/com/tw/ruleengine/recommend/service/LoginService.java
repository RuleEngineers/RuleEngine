package com.tw.ruleengine.recommend.service;

import com.tw.ruleengine.recommend.Users;
import com.tw.ruleengine.recommend.components.ParseUserDetails;
import com.tw.ruleengine.recommend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private MovieRepository movieRepository;
    private ParseUserDetails parseUserDetails;


    @Autowired
    public LoginService(MovieRepository movieRepository, ParseUserDetails parseUserDetails) {
        this.movieRepository = movieRepository;
        this.parseUserDetails = parseUserDetails;
    }

    public String addDetails(Users user) {

        movieRepository.save(user);
        return "success";
    }

    public String validateLogin(String details)
    {
        String userId=parseUserDetails.parseUserId(details);
        String password=parseUserDetails.parsePassword(details);
        Users user=movieRepository.findOne(userId);
        if(user==null)
        {
            return "WrongUserId";
        }
        if(user.getPassword().equals(password))
        {
            return "success";
        }
        else
            return "Wrong password";
    }

    public void parseDetails(String details) {
        Users user=parseUserDetails.parse(details);
        addDetails(user);
    }


}
