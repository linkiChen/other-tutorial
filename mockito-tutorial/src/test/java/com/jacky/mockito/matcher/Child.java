package com.jacky.mockito.matcher;

public class Child implements Parent {
    @Override
    public int work() {
        throw new RuntimeException();
    }
}
