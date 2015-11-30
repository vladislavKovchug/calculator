package com.teamdev.fsm;


public interface StateAcceptor<Context extends FiniteStateMachineContext>{
    boolean accept(Context context);
}
