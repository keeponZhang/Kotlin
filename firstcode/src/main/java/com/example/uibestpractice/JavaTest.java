package com.example.uibestpractice;

/**
 * createBy keepon
 */
class JavaTest {
    public static void main(String[] args) {
        Success success = new Success("success");
        Failure failure = new Failure(new RuntimeException("failure"));
    }

    public static void testResult(Result result) {

    }
}
