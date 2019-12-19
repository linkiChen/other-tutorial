package com.jacky.mockito.mock;

import com.jacky.mockito.common.Account;
import com.jacky.mockito.common.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockByAnnotationTest {

    @Before
    public void init() {
        // 使用@Mock生效
        MockitoAnnotations.initMocks(this);
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountDao snAccountDao;

    @Mock
    private AccountDao accountDao;

    @Test
    public void testMock() {
        final Account account = accountDao.findAccount("", "");
        System.out.println("default answer mock: " + account);

        final Account snAccount = snAccountDao.findAccount("", "");
        System.out.println("\nsmart null answer mock:\n" + snAccount);
    }
}
