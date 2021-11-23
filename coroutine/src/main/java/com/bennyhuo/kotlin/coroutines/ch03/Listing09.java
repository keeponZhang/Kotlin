package com.bennyhuo.kotlin.coroutines.ch03;

import com.bennyhuo.kotlin.coroutine.ch03.Listing08Kt;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

public class Listing09 {
    public static void main(String[] args) {
        Object result = Listing08Kt.notSuspend(new Continuation<Integer>() {
            @Override
            public CoroutineContext getContext() {
                return EmptyCoroutineContext.INSTANCE;
            }

            @Override
            public void resumeWith(@NotNull Object o) {

            }
        });
    }
}
