package com.kotlin.action.ch06.java;

import java.util.List;

interface DataParser<T> {
    void parseData(String input,
                   List<T> output,
                   List<String> errors);
}