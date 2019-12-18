package com.kotlin.action.bean;

import com.kotlin.action.bean.interfaces.State;
import com.kotlin.action.bean.interfaces.View;

public class Button implements View {

    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public State restorState() {
        return null;
    }

    //内部类持有外部类的引用  ,Button是不可序列化的，所以会破坏ButtonState的序列化
    public class ButtonState implements State{

    }
}

