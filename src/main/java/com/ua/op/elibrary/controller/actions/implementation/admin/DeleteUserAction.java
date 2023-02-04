package com.ua.op.elibrary.controller.actions.implementation.admin;

import com.ua.op.elibrary.controller.actions.Action;
import com.ua.op.elibrary.model.dao.implementation.UserDAOImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static com.ua.op.elibrary.controller.actions.constants.Pages.*;
import static com.ua.op.elibrary.controller.actions.constants.Parameters.*;

public class DeleteUserAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String forward = "controller?action=librarians-list";
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.delete(Long.parseLong(request.getParameter(USER_ID)));
        return forward;
    }
}
