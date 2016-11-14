package com.tcs.ilp.Cache.UserSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDataServiceImpl implements SessionDataService {

    public static final String CLASSNAME = SessionDataServiceImpl.class.getName();
    public static String userName;
    @Override
    public void checkUserSession(HttpServletRequest request,
            HttpServletResponse response) {
        HttpSession userSession = request.getSession();

        //check if the user is already logged in somewhere
        //multiple logins are not permissible
        setUserName((String) userSession.getAttribute("userName"));
    }

    public static HttpSession getUserSession() {
        
        return null;
    }

    @Override
    public void setUserSession(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean validateUserSession() {
        // TODO Auto-generated method stub
        return false;
    }

    protected static String  getUserName() {
        return userName;
    }

    protected static void setUserName(String aUserName){
        userName = aUserName;
    }
}
