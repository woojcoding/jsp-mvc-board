package com.study.controller;

import com.study.command.BoardDeleteHandler;
import com.study.command.BoardInfoHandler;
import com.study.command.BoardListHandler;
import com.study.command.BoardModifyHandler;
import com.study.command.BoardPasswordValidateHandler;
import com.study.command.BoardPostHandler;
import com.study.command.BoardUpdateHandler;
import com.study.command.BoardWriteHandler;
import com.study.command.CommandHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize =  1024 * 1024 * 5 * 3
)
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
        request.setCharacterEncoding("utf-8");

        String command = request.getParameter("cmd");

        CommandHandler handler = null;

        if (command.equals("list")) {
            handler = new BoardListHandler();
        } else if (command.equals("get")) {
            handler = new BoardInfoHandler();
        } else if (command.equals("write")) {
            handler = new BoardWriteHandler();
        } else if (command.equals("post")) {
            handler = new BoardPostHandler();
        } else if (command.equals("modify")) {
            handler = new BoardModifyHandler();
        } else if (command.equals("update")) {
            handler = new BoardUpdateHandler();
        } else if (command.equals("validate")) {
            handler = new BoardPasswordValidateHandler();
        } else if (command.equals("delete")) {
            handler = new BoardDeleteHandler();
        }

        if (handler == null) {
            throw new IllegalArgumentException("Invalid command: " + command);
        }

        String viewPage = handler.process(request, response);

        if (viewPage.startsWith("/board?cmd=")) {
            response.sendRedirect(viewPage);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);

            dispatcher.forward(request, response);
        }
    }
}

