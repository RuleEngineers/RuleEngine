package com.tw.ruleengine.recommend.service;

import com.tw.ruleengine.recommend.Users;
import com.tw.ruleengine.recommend.components.ParseUserDetails;
import com.tw.ruleengine.recommend.controller.WebContextLoader;
import com.tw.ruleengine.recommend.repository.MovieRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {ApplicationConfig.class})
@ContextConfiguration(loader = WebContextLoader.class, locations = {"file:src/main/webapp/WEB-INF/Login-servlet.xml"})
public class LoginServiceTest {


    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ParseUserDetails parseUserDetails;

    @Test
    public void shouldAddUserDetails()
    {
        LoginService loginService=new LoginService(movieRepository, parseUserDetails);
        Users user=new Users("xyz","xyz@gmail.com","xyz","abc");
        String actual=loginService.addDetails(user);
        Assert.assertEquals(actual,"success");
    }
    @Test
    public void shouldValidateLogin()
    {
        LoginService loginService=new LoginService(movieRepository, parseUserDetails);
        String details="xyz;abc";
        String actual = loginService.validateLogin(details);
        Assert.assertEquals(actual,"success");
    }


//    @After
//    public void setup(){
//        movieRepository.deleteAll();
//    }


}
