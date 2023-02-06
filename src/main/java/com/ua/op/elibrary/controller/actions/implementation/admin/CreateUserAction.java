package com.ua.op.elibrary.controller.actions.implementation.admin;

import com.ua.op.elibrary.controller.actions.Action;
import com.ua.op.elibrary.model.dao.implementation.UserDAOImpl;
import com.ua.op.elibrary.model.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static com.ua.op.elibrary.controller.actions.constants.Parameters.*;

public class CreateUserAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String forward = "controller?action=librarians-list";
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = User.builder().
                userFirstname(request.getParameter(USER_FIRSTNAME)).
                userLastname(request.getParameter(USER_LASTNAME)).
                userPhoneNumber(request.getParameter(USER_PHONE_NUMBER)).
                userEmail(request.getParameter(USER_EMAIL)).
                userPassword(request.getParameter(USER_PASSWORD)).
                userRole(Integer.parseInt(request.getParameter(USER_ROLE))).
                build();
        userDAO.add(user);
        return forward;
    }
}
