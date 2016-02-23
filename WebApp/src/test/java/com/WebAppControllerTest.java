//package com;
//
//import com.google.gson.Gson;
//import java.lang.reflect.Type;
//
//import com.google.gson.reflect.TypeToken;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.initMocks;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(loader = WebContextLoader.class, locations = {"file:src/main/webapp/WEB-INF/WebApp-servlet.xml"})
//public class WebAppControllerTest {
//
//    @Mock
//    RuleEngineService mockRuleEngineService;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        initMocks(this);
//        mockMvc = standaloneSetup(new WebAppController(mockRuleEngineService))
//                .build();
//
//    }
//
//    @Test
//    public void shouldAddRule() throws Exception {
//
//        List<Rule> rules = new ArrayList<Rule>();
//        Rule rule = new Rule("10<20", "/path");
//        rules.add(0,rule);
//        //rules.add(1,rule);
//        when(.findAll()).thenReturn(rules);
//        MvcResult mvcResult = mockMvc.perform(get("/api/rule"))
//                .andExpect(status().isOk())
//                .andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        Type listType = new TypeToken<ArrayList<Rule>>(){}.getType();
//        List<Rule> rule1 = new Gson().fromJson(contentAsString, listType);
//        System.out.println("Rule1: "+rule1);
//        //Assert.assertEquals(rules.size(),1);
//        Assert.assertEquals(rules.get(0),rule1.get(0));
//
//
//
//
//        Rule rule = new Rule("10<20", "/path");
//        String ruleJson = new Gson().toJson(rule);
//        mockMvc.perform(post("/api/rule").content(ruleJson).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(view().name("success"));
//    }
//
//
//    }
//
//
