package com.teamdev.calculator;

import com.teamdev.fsm.FiniteStateMachineContext;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculationContext implements FiniteStateMachineContext {

    final private Deque<Double> numbersStack = new ArrayDeque<>();

    final private Deque<String> expressionStack = new ArrayDeque<>();

    private double result;

    public CalculationContext(String expression) {
        this.expressionStack.push(expression);
    }

    public Deque<Double> getNumbersStack() {
        return numbersStack;
    }

    public Deque<String> getExpressionStack() {
        return expressionStack;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
