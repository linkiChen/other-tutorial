package com.jacky.mockito.stubbing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {

    private List<String> list;

    @Before
    public void init() {
        this.list = mock(ArrayList.class);
    }

    @Test
    public void stubbingUsage() {
        // 实际上list中没有元素,通过以下的stubbing
        // 相当于在list的第一个位置中插入了元素'first'
        when(list.get(0)).thenReturn("first");
        assertThat(list.get(0), equalTo("first"));

        // 当调用get时传入Int类型的参数则抛出运行时异常
        when(list.get(anyInt())).thenThrow(new RuntimeException());
        try {
            list.get(0);
            fail();
        } catch (Exception e) {
            // 当抛出异常是判断是否是RuntimeException
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }


    @Test
    public void voidMethodStubbing() {
        doNothing().when(list).clear();
        list.clear();

        // 验证list是否执行了clear方法
        verify(list, times(1)).clear();

        doThrow(RuntimeException.class).when(list).clear();
        try {
            list.clear();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void stubbingDoReturn() {
        when(list.get(0)).thenReturn("first");
        doReturn("second").when(list).get(1);

        assertThat(list.get(0), equalTo("first"));
        assertThat(list.get(1), equalTo("second"));
    }

    @Test
    public void iterateStubbing() {
        when(list.size()).thenReturn(1, 2, 3, 4);

        // 第一次调用.size时返回1,第二次返回2 ...
        assertThat(list.size(), equalTo(1));
        assertThat(list.size(), equalTo(2));
    }

    @Test
    public void stubbingWithAnswer() {
        when(list.get(anyInt())).thenAnswer(invocation -> {
            final Integer index = invocation.getArgumentAt(0, Integer.class);
            return String.valueOf(index * 10);
        });

        assertThat(list.get(0), equalTo("0"));
        assertThat(list.get(99), equalTo("990"));
    }

    @Test
    public void stubbingWithRealCall() {
        final StubbingService ss = mock(StubbingService.class);
        // 这里mock出来的ss实际上是Mockito通过CGLIB代理出来的一个对象
        // 而ss.getId()也根本没有调用到真正的StubbingService上的getId()
        final int id = ss.getId();
        System.out.println(id);

        when(ss.getString()).thenReturn("string");
        assertThat(ss.getString(), equalTo("string"));

        when(ss.getId()).thenCallRealMethod();
        // 调用真正的StubbingService实例的getId方法,也不是代理出来的对象的getId
        System.out.println("real call method getId:" + ss.getId());
    }

    @After
    public void destroy() {
        reset(this.list);
    }
}
