package com.study.controller;

import com.study.command.BoardListHandler;
import com.study.command.CommandHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board")
public class BoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String command = request.getParameter("cmd");

        CommandHandler handler = null;

        if (command.equals("list")) {
            handler = new BoardListHandler();
        }

        if (handler == null) {
            throw new IllegalArgumentException("Invalid command: " + command);
        }

        String viewPage = handler.process(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);

        dispatcher.forward(request, response);
    }
}

