package com.teamdev.calculator;

import com.teamdev.fsm.StateAcceptor;

public class NumberParser implements StateAcceptor<CalculationContext> {
    @Override
    public boolean accept(CalculationContext context) {
        final Double result = new Double(context.getExpressionStack().peek());
        context.getNumbersStack().push(result);
        context.setResult(result);
        return true;
    }
}
