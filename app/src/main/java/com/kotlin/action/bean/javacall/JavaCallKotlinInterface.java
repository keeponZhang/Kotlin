package com.kotlin.action.bean.javacall;

import ch04.ex1_1_1_InterfacesInKotlin.Clickable;

/**
 * createBy keepon
 */
//java实现kotlin带默认方法的接口时，默认方法也要实现
public class JavaCallKotlinInterface implements Clickable {
    @Override
    public void click() {

    }

    @Override
    public void clickDefault() {

    }
}
