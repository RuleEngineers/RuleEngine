package com.tw.ruleengine;

import com.tw.ruleengine.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class RuleTest {

    @Test
    public void shouldReturn0IfEqual() throws Exception {
        Rule rule1 = new Rule("", "", 1, 0.5d);
        Rule rule2 = new Rule("", "", 1, 0.5d);

        int actual = rule1.compareTo(rule2);

        assertEquals(0, actual);
    }

    @Test
    public void shouldReturn1IfGreater() throws Exception {
        Rule rule1 = new Rule("", "", 1, 0.5d);
        Rule rule2 = new Rule("", "", 1, 0.4d);

        int actual = rule1.compareTo(rule2);

        assertEquals(1, actual);
    }

    @Test
    public void shouldReturnMinus1IfLesser() throws Exception {
        Rule rule1 = new Rule("", "", 1, 0.3d);
        Rule rule2 = new Rule("", "", 1, 0.4d);

        int actual = rule1.compareTo(rule2);

        assertEquals(-1, actual);
    }
}