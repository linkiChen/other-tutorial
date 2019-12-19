package com.jacky.mockito.mock;

import com.jacky.mockito.common.Account;
import com.jacky.mockito.common.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;

public class MockByRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private AccountDao annoAccountDao;

    @Test
    public void testMock() {
        final AccountDao accountDao = mock(AccountDao.class);
        final Account account = accountDao.findAccount("", "");
        System.out.println(account);
    }
}
