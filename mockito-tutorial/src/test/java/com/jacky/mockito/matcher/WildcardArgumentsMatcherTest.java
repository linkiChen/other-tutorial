package com.jacky.mockito.matcher;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WildcardArgumentsMatcherTest {

    @Mock
    private MatcherService matcherService;

    @Test
    public void wildcardMethod() {
        // 通用配置的stubbing,参数分别为:任意的Int,任意的字符串,任务Collection子集,Serializable的任意实例
        when(matcherService.function1(anyInt(), anyString(), anyCollection(), isA(Serializable.class))).thenReturn(100);
        final int res = matcherService.function1(2, "Jacky", Collections.emptyList(), "serial");
        assertThat(res, equalTo(100));
    }

    @Test
    public void wildcardMethodWithSpec() {
        // 将通配的stubbing放到最后会将前面的精准的stubbing覆盖掉,所以当既有精准stubbing又有通配的stubbing时需要将通配的stubbing放置到最前面
        when(matcherService.function1(anyInt(), anyString(), anyCollection(), isA(Serializable.class))).thenReturn(-1);
        // 这里的"jacky"/"chen"不能直接填写字符串
        when(matcherService.function1(anyInt(), eq("jacky"), anyCollection(), isA(Serializable.class))).thenReturn(100);
        when(matcherService.function1(anyInt(), eq("chen"), anyCollection(), isA(Serializable.class))).thenReturn(200);

        int res = matcherService.function1(1, "chen", Collections.emptyList(), "mockito");
        assertThat(res, equalTo(200));
        res = matcherService.function1(2, "jacky", Collections.emptyList(), "Mock");
        assertThat(res, equalTo(100));
        res = matcherService.function1(3, "other", Collections.emptyList(), "other");
        assertThat(res, equalTo(-1));
    }

    @Test
    public void wildcardVoidMethod() {
        doNothing().when(matcherService).function2(anyInt(), eq("jacky"), anyCollection(), isA(Serializable.class));
        matcherService.function2(1, "jacky", Collections.emptyList(), "jacky");
        // 当方法没有返回值时可以用verify验证方法是否有被调用(执行到)
        verify(matcherService, times(1)).function2(1, "jacky", Collections.emptyList(), "jacky");
    }

    @After
    public void destroy() {
        reset(matcherService);
    }
}
