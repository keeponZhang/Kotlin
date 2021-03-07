package com.example.broadcastbestpractice;

/**
 * createBy	 keepon
 */
class JavaTest6 {
    public static void main(String[] args) {
        //匿名内部类里面不能进行全局返回
        Runnable runnable = (Runnable)(new Runnable() {
            public final void run() {
               return;
            }
        });
    }
}
