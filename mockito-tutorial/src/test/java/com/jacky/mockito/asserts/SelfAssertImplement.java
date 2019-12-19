package com.jacky.mockito.asserts;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SelfAssertImplement {

    @Test
    public void test() {
        assertThat(10, GreatThan.gt(8));
    }
}
