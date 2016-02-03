package com;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static junit.framework.TestCase.assertEquals;


@ContextConfiguration(classes = {ApplicationConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckoneTest {

    @Test
    public void shouldCheck()
    {
        Checkone checkone = new Checkone();
        assertEquals((Integer)10,checkone.shouldEvaluate("2*4+2"));
    }
}
