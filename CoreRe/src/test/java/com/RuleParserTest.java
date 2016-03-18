package com;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RuleParserTest {

    private RuleParser ruleParser;



    @Before
    private void setUp() {
        ruleParser = new RuleParser();
    }

    @Test
    public void testParseRule() throws Exception {
        String ruleString = "WHEN {age} ISGREATERTHAN 20 THEN abc.html WEIGHT 1";
        String expectedParsedRuleString = "; {age} > 20 ; abc.html";
        String actualParsedRuleString = ruleParser.parseRule(ruleString);
        assertEquals(expectedParsedRuleString, actualParsedRuleString);
    }
}