package com.jacky.mockito.matcher;

public class Son implements Parent {
    @Override
    public int work() {
        throw new RuntimeException();
    }
}
