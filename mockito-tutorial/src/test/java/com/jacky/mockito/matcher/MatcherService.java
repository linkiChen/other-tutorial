package com.jacky.mockito.matcher;

import java.io.Serializable;
import java.util.Collection;

public class MatcherService {

    public int function1(int i, String str, Collection<?> collection, Serializable serializable) {
        throw new RuntimeException();
    }

    public void function2(int i, String str, Collection<?> collection, Serializable serializable) {

    }
}
