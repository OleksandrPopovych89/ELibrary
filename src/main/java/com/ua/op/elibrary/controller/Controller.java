package com.ua.op.elibrary.controller;

import com.ua.op.elibrary.controller.actions.Action;
import com.ua.op.elibrary.controller.actions.ActionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.ua.op.elibrary.controller.actions.constants.Pages.*;
import static com.ua.op.elibrary.controller.actions.constants.Parameters.ACTION;

public class Controller extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private static final ActionFactory ACTION_FACTORY = ActionFactory.getActionFactory();

    @Override
    public void init() {
        System.out.println("Servlet is init");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet worked");
        request.getRequestDispatcher(getPath(request, response)).forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(getPath(request, response));
    }

    @Override
    public void destroy() {
        System.out.println("Destroy!!!");
    }

    private String getPath(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter(ACTION));
        Action action = ACTION_FACTORY.createAction(request.getParameter(ACTION));
        String path = ERROR_PAGE;

        try {
            path = action.execute(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return path;
    }
}