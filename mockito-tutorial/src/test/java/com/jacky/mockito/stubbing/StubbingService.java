package com.jacky.mockito.stubbing;

import java.util.Random;

public class StubbingService {

    public int getId() {
        System.out.println("---------- getId ----------");
        return new Random().nextInt(15);
    }

    public String getString() {
        throw new RuntimeException();
    }
}
