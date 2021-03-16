package com.kotlin.action.ch04.java;

/**
 * createBy keepon
 */
public class TestRunnable {
   public void postponeComputation(int delay, Runnable computation){
       computation.run();
   }
}
