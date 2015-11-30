package com.teamdev.calculator;

import com.teamdev.fsm.StateAcceptor;

/**
 * @author vladislav.kovchug
 */
public class FinishParser implements StateAcceptor<CalculationContext> {
    @Override
    public boolean accept(CalculationContext context) {
        return true;
    }
}
