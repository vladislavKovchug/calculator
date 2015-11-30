package com.teamdev.fsm;

public interface FiniteStateMachine<
        Context extends FiniteStateMachineContext,
        Error extends Exception,
        Result> {

    Result run(Context context) throws Error;

}
