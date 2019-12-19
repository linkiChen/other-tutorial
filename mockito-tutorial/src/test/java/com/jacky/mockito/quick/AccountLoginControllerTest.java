package com.jacky.mockito.quick;

import com.jacky.mockito.common.Account;
import com.jacky.mockito.common.AccountDao;
import com.jacky.mockito.common.AccountLoginController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {

    private AccountDao accountDao;

    private HttpServletRequest request;

    private AccountLoginController accountLoginController;

    @Before
    public void setUp() {
        this.accountDao = Mockito.mock(AccountDao.class);
        this.request = Mockito.mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(this.accountDao);
    }

    @Test
    public void testLoginSuccess() {
        Account account = new Account();
        Mockito.when(request.getParameter("userName")).thenReturn("jacky");
        Mockito.when(request.getParameter("password")).thenReturn("admin");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);

        assertThat(accountLoginController.login(this.request), equalTo("/index"));
    }

    @Test
    public void testLoginFail() {
        Mockito.when(request.getParameter("userName")).thenReturn("jacky");
        Mockito.when(request.getParameter("password")).thenReturn("admin");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(null);

        assertThat(accountLoginController.login(this.request), equalTo("/login"));
    }

    @Test
    public void testLogin505() {
        Mockito.when(request.getParameter("userName")).thenReturn("jacky");
        Mockito.when(request.getParameter("password")).thenReturn("admin");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenThrow(UnsupportedOperationException.class);

        assertThat(accountLoginController.login(this.request), equalTo("/505"));
    }
}
