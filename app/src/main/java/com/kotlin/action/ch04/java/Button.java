package com.kotlin.action.ch04.java;

import java.io.Serializable;

interface State extends Serializable {

}

interface View {
    State getCurrentState();

    void restoreState(State state);
}

public class Button implements View  {

    @Override
    public State getCurrentState() {
        return  new ButtonState();
    }

    @Override
    public void restoreState(State state) {

    }
    public class ButtonState implements State{

    }
}


