package com.jacky.mockito.asserts;

public interface Compare<T> {

    boolean compare(T expect, T actual);
}
