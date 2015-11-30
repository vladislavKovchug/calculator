package com.teamdev.calculator;


import com.teamdev.fsm.StateAcceptor;
import com.teamdev.fsm.StateAcceptorFactory;

public class ParserFactory implements StateAcceptorFactory<CalculationContext, CalculationState, StateAcceptor<CalculationContext>> {

    @Override
    public StateAcceptor<CalculationContext> getAcceptor(CalculationState expectedState) {
        if(expectedState == CalculationState.NUMBER){
            return new NumberParser();
        }
        if(expectedState == CalculationState.FINISH){
            return new FinishParser();
        }
        throw new RuntimeException("No acceptor for " + expectedState.getClass().getName() + "." + expectedState.toString());
    }
}
