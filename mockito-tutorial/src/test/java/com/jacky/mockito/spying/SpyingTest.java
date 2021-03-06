package com.jacky.mockito.spying;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpyingTest {

    @Test
    public void testSpy() {
        List<String> list = new ArrayList<>();

        List<String> spyList = spy(list);
        spyList.add("Mockito");
        spyList.add("PowerMock");

        assertThat(spyList.get(0), equalTo("Mockito"));
        assertThat(spyList.get(1), equalTo("PowerMock"));
        assertThat(spyList.isEmpty(), equalTo(false));

        // 只stubbing mock对象的部分方法
        when(spyList.isEmpty()).thenReturn(true);
        when(spyList.size()).thenReturn(0);

        assertThat(spyList.get(0), equalTo("Mockito"));
        assertThat(spyList.get(1), equalTo("PowerMock"));
        /**
         * 实际上spyList的isEmpty()是false,size()是2
         * 但是通过对spyList的isEmpty和size方法的stubbing后,
         * 再调用spyList的这两个方法是实际上就是调用Mockito
         * 代理对象的方法,得到的返回值也就是stubbing返回的值了
         */
        assertThat(spyList.isEmpty(), equalTo(true));
        assertThat(spyList.size(), equalTo(0));
    }
}
