package com.study.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPage = "/jsp/Hello.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPage = "/jsp/Hello.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);

        dispatcher.forward(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String viewPage = "/jsp/Hello.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);

        dispatcher.forward(request, response);
    }
    }
