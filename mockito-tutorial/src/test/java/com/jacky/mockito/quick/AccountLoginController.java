package com.jacky.mockito.quick;

import javax.servlet.http.HttpServletRequest;


public class AccountLoginController {

    private final AccountDao accountDao;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request) {
        final String userName = request.getParameter("userName");
        final String password = request.getParameter("password");
        try {
            final Account account = accountDao.findAccount(userName, password);
            if (account == null) {
                return "/login";
            } else {
                return "index";
            }
        } catch (Exception e) {
            return "/505";
        }
    }

}
