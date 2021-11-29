package com.bennyhuo.kotlin.coroutines.book.ch03;

import com.bennyhuo.kotlin.coroutine.ch03.Listing07Kt;
import com.bennyhuo.kotlin.coroutine.ch03.Listing08Kt;

import org.jetbrains.annotations.NotNull;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

import static com.bennyhuo.kotlin.coroutines.utils.LogKt.log;


public class Listing09 {
    public static void main(String[] args) {
        Object result = Listing08Kt.notSuspend(new Continuation<Integer>() {
            @Override
            public CoroutineContext getContext() {
                return EmptyCoroutineContext.INSTANCE;
            }

            @Override
            public void resumeWith(@NotNull Object o) {
                System.out.println("---------------"+o);
                log("result o " + o);
            }
        });
        log("result o " + result);
        // while (true){
        //     log("");
        // }
        Listing07Kt.suspendFunc02("a", "b", new Continuation<Integer>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return EmptyCoroutineContext.INSTANCE;
            }

            @Override
            public void resumeWith(@NotNull Object o) {
                log("suspendFunc02");
            }
        });
    }
}
