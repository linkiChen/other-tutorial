package com.jacky.mockito.matcher;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class ArgumentsMatcherTest {

    @Test
    public void basicTest() {
        List<Integer> list = mock(ArrayList.class);

        when(list.get(0)).thenReturn(100);
        assertThat(list.get(0), equalTo(100));
        // 因为1没有stubbing,所以get(1)得到的是null
        assertThat(list.get(1), nullValue());
    }

    @Test
    public void testComplex() {
        Foo foo = mock(Foo.class);
        // foo调用fun时传入的参数是Parent的一个实例时,返回100
        when(foo.fun(isA(Parent.class))).thenReturn(100);

        int res = foo.fun(new Son());
        assertThat(res, equalTo(100));

        reset(foo);

        // any 只要语法允许,不懂传递的参数是什么都为true
        // Any的matches实际上是直接返回true
        when(foo.fun(any(Child.class))).thenReturn(100);
        res = foo.fun(new Son());
        assertThat(res, equalTo(100));
    }
}
