package com.teamdev.calculator;

import com.teamdev.fsm.FiniteStateMachineContext;

public class CalculationContext implements FiniteStateMachineContext {

    final private String expression;

    private double result;

    public CalculationContext(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
