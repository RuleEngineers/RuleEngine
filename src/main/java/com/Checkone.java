package com;

import groovy.util.Eval;

public class Checkone {
    public Integer shouldEvaluate(String condition) {
        return (Integer)(Eval.me(condition));
    }
}
