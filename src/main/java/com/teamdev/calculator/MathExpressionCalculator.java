package com.teamdev.calculator;

import com.teamdev.fsm.AbstractFiniteStateMachine;
import com.teamdev.fsm.StateAcceptor;

public class MathExpressionCalculator extends AbstractFiniteStateMachine<
        CalculationContext, CalculationState,
        StateAcceptor<CalculationContext>, ParserFactory,
        CalculationMatrix, CalculationError, Double>
        implements Calculator {

    final private ParserFactory parserFactory = new ParserFactory();
    final private CalculationMatrix matrix = new CalculationMatrix();

    @Override
    public double calculate(String expression) throws CalculationError {
        return run(new CalculationContext(expression));
    }

    @Override
    protected Double prepareResult(CalculationContext context) {
        return context.getResult();
    }

    @Override
    protected void deadlock(CalculationContext context) throws CalculationError {
        throw new CalculationError("", -1);
    }

    @Override
    protected ParserFactory getStateAcceptorFactory() {
        return parserFactory;
    }

    @Override
    protected CalculationMatrix getTransitionMatrix() {
        return matrix;
    }

    @Override
    protected void acceptStep(CalculationContext context) {

    }

    public static void main(String[] args) throws Exception {
        final MathExpressionCalculator calculator = new MathExpressionCalculator();
        final double result = calculator.calculate("17.387");
        System.out.println("result = " + result);
    }
}
