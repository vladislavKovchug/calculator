package com.teamdev.fsm;


import java.util.Set;

public abstract class AbstractFiniteStateMachine<
        Context extends FiniteStateMachineContext,
        State extends Enum,
        Acceptor extends StateAcceptor<Context>,
        AcceptorFactory extends StateAcceptorFactory<Context, State, Acceptor>,
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
            acceptStep(context);
        }

        return prepareResult(context);
    }

    private State moveForward(State currentState, Context context) {

        final Set<State> possibleTransitions = getTransitionMatrix().
                getPossibleTransitions(currentState);

        for (State state : possibleTransitions) {
            if(getStateAcceptorFactory().getAcceptor(state).accept(context)){
                return state;
            }
        }

        return null;
    }

    protected abstract void acceptStep(Context context);

    protected abstract Result prepareResult(Context context);

    protected abstract void deadlock(Context context) throws Error;

    protected abstract AcceptorFactory getStateAcceptorFactory();

    protected abstract Matrix getTransitionMatrix();
}
