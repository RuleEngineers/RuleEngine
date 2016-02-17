//package com;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//import MockMvcBuilders.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration("servlet-context.xml")
//public class SampleTests {
//
//    @Autowired
//    private WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = webAppContextSetup(this.wac).build();
//    }
//
//    @Test
//    public void getFoo() throws Exception {
//        this.mockMvc.perform(get("/foo").accept("application/json"))
//                .andExpect(status().isOk())
//                .andExpect(content().mimeType("application/json"))
//                .andExpect(jsonPath("$.name").value("Lee"));
//    }
//}