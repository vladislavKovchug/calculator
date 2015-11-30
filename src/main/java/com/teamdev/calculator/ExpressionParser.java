package com.teamdev.calculator;

import com.teamdev.fsm.StateAcceptor;

public class ExpressionParser implements StateAcceptor<CalculationState, CalculationContext> {

    @Override
    public boolean accept(CalculationState expectedState, CalculationContext context) {
        final Double result = new Double(context.getExpression());
        context.setResult(result);
        return true;
    }
}
