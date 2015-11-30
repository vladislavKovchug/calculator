package com.teamdev.fsm;


import java.util.Set;

public abstract class AbstractFiniteStateMachine<
        Context extends FiniteStateMachineContext,
        State extends Enum,
        Acceptor extends StateAcceptor<State, Context>,
        Matrix extends TransitionMatrix<State>,
        Error extends Exception,
        Result>

        implements FiniteStateMachine<Context, Error, Result> {

    @Override
    public Result run(Context context) throws Error {

        final Matrix matrix = getTransitionMatrix();

        State state = matrix.getStartState();

        while (state != matrix.getFinishState()) {

            state = moveForward(state, context);

            if (state == null) {
                deadlock(context);
                break;
            }
        }

        return prepareResult(context);
    }

    private State moveForward(State currentState, Context context) {

        final Set<State> possibleTransitions = getTransitionMatrix().
                getPossibleTransitions(currentState);

        for (State state : possibleTransitions) {
            if (getStateAcceptor().accept(state, context)) {
                return state;
            }
        }

        return null;
    }

    protected abstract Result prepareResult(Context context);

    protected abstract void deadlock(Context context) throws Error;

    protected abstract Acceptor getStateAcceptor();

    protected abstract Matrix getTransitionMatrix();
}
