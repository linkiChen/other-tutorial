package com.jacky.mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class DeepMockTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Service deepMockService;

    @Mock
    private Service service;

    @Mock
    private ServiceResult sr;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeepMock() {

        // 此时的serviceResult是个空对象,调用foo会报NPE
//        final ServiceResult serviceResult = service.get();
//        serviceResult.foo();

        // 规范mock出来的Service对象的行为,即 当service调用get()方法时,返回
        // mock出来的serviceResult
        when(service.get()).thenReturn(sr);
        final ServiceResult serviceRes = service.get();
    serviceRes.foo();

    }

    @Test
    public void oneStepDeepMock() {
        // 使用DEEP_STUBS mock出来的对象会将它所依赖/方法所返回的对象一并mock出来
        final ServiceResult serviceResult = deepMockService.get();
        serviceResult.foo();
    }
}
