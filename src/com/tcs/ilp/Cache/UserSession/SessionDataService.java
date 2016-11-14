package com.tcs.ilp.Cache.UserSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface SessionDataService {

    public static final String CLASSNAME = SessionDataService.class.getName();

    public void checkUserSession(HttpServletRequest request, HttpServletResponse response);

    public void setUserSession(HttpServletRequest request, HttpServletResponse response);

    public boolean validateUserSession();
}
