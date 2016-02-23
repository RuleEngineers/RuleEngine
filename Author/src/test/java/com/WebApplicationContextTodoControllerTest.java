//package com;
//
//import com.TestContext;
//import com.Main;
//import com.WebAppContext;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
////@ContextConfiguration(locations = {"classpath:testContext.xml", "classpath:exampleApplicationContext-web.xml"})
//@WebAppConfiguration
//public class WebApplicationContextTodoControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Main todoServiceMock;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Before
//    public void setUp() {
//        //We have to reset our mock between tests because the mock objects
//        //are managed by the Spring container. If we would not reset them,
//        //stubbing and verified behavior would "leak" from one test to another.
//        Mockito.reset(todoServiceMock);
//
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//}
