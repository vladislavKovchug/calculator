package com.teamdev.fsm;


public interface StateAcceptorFactory<
        Context extends FiniteStateMachineContext,
        State extends Enum,
        Acceptor extends StateAcceptor<Context>> {

    public Acceptor getAcceptor(State expectedState);

}
