package com.tcs.ilp.Util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GeneralMethods {
    private static RequestDispatcher requestDispatcher = null;

    public static void RequestForward(HttpServletRequest request,
            HttpServletResponse response, String url) {

        requestDispatcher = request.getRequestDispatcher(url);
        try {
            requestDispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    public static void RequestInclude(HttpServletRequest request,
            HttpServletResponse response, String url) {

        requestDispatcher = request.getRequestDispatcher(url);
        try {
            requestDispatcher.include(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
