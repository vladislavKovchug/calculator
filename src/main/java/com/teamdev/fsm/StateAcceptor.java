package com.teamdev.fsm;


public interface StateAcceptor<State extends Enum,
        Context extends FiniteStateMachineContext>{

    boolean accept(State expectedState, Context context);
}
