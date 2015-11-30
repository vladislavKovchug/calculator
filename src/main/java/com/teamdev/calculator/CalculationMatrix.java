package com.teamdev.calculator;

import com.teamdev.fsm.TransitionMatrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.teamdev.calculator.CalculationState.START;
import static com.teamdev.calculator.CalculationState.NUMBER;
import static com.teamdev.calculator.CalculationState.FINISH;
import static java.util.EnumSet.noneOf;
import static java.util.EnumSet.of;

public class CalculationMatrix implements TransitionMatrix<CalculationState> {

    private Map<CalculationState, Set<CalculationState>> transitions = new HashMap<
            CalculationState, Set<CalculationState>>() {{
        put(START, of(NUMBER));
        put(NUMBER, of(FINISH));
        put(FINISH, noneOf(CalculationState.class));
    }};

    @Override
    public CalculationState getStartState() {
        return START;
    }

    @Override
    public CalculationState getFinishState() {
        return FINISH;
    }

    @Override
    public Set<CalculationState> getPossibleTransitions(CalculationState calculationState) {
        return transitions.get(calculationState);
    }
}
