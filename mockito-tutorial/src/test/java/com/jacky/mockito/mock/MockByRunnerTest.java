package com.jacky.mockito.mock;

import com.jacky.mockito.common.Account;
import com.jacky.mockito.common.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {

    @Test
    public void testMock() {
        AccountDao accountDao = mock(AccountDao.class);
        final Account account = accountDao.findAccount("", "");
        System.out.println("defaults answer mock: " + account);

        final AccountDao accountDao1 = mock(AccountDao.class, Mockito.RETURNS_SMART_NULLS);
        final Account account1 = accountDao1.findAccount("", "");
        System.out.println("\nsmart null answer mock: \n" + account1);
    }
}
