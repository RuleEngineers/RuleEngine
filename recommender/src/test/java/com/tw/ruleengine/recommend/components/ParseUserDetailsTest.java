package com.tw.ruleengine.recommend.components;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.tw.ruleengine.recommend.Users;
import com.tw.ruleengine.recommend.controller.WebContextLoader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {ApplicationConfig.class})
@ContextConfiguration(loader = WebContextLoader.class, locations = {"file:src/main/webapp/WEB-INF/Login-servlet.xml"})
public class ParseUserDetailsTest {

    ParseUserDetails parseUserDetails = new ParseUserDetails();
    @Test
    public void shouldParseDetails() {
        String details = "abc;abc@gmnail.com;abc;pqr";

        Users user = parseUserDetails.parse(details);
        Users expected = new Users("abc", "abc@gmnail.com", "abc", "pqr");
        Assert.assertEquals(user,expected);
    }

    @Test
    public void shouldParseUserId(){
        String details="userId;pwd";
        String actual=parseUserDetails.parseUserId(details);
        Assert.assertEquals(actual,"userId");
    }

    @Test
    public void shouldParseUserPassword(){
        String details="userId;pwd";
        String actual=parseUserDetails.parsePassword(details);
        Assert.assertEquals(actual,"pwd");
    }
}
