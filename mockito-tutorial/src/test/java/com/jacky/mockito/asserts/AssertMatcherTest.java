package com.jacky.mockito.asserts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertMatcherTest {

    @Test
    public void test() {
        int i = 10;
        assertThat(i, equalTo(10));
        assertThat(i, not(equalTo(20)));
        assertThat(i, is(10));
        assertThat(i, is(not(20)));
        assertThat(i, not(is(20)));


    }

    @Test
    public void test2() {
        double price = 25.26;
        // ||
        assertThat(price, either(equalTo(25.26)).or(equalTo(26.15)));
        // &&
        assertThat(price, both(equalTo(25.26)).and(not(equalTo(25.46))));

        assertThat(price, anyOf(is(23.45), is(45.84), is(25.26)));
    }

    @Test
    public void test3() {
        double price = 12.3;
        assertThat("assert double value fail", price, not(equalTo(12.4)));
    }
}
