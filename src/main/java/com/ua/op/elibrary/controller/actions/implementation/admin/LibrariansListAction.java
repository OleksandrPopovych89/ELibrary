package com.ua.op.elibrary.controller.actions.implementation.admin;

import com.ua.op.elibrary.controller.actions.Action;
import com.ua.op.elibrary.model.dao.UserDAOImpl;
import com.ua.op.elibrary.model.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.List;

import static com.ua.op.elibrary.controller.actions.constants.Pages.LIBRARIANS_LIST_PAGE;

public class LibrariansListAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<User> userList = new UserDAOImpl().getAll();
        request.setAttribute("librarians", userList);
        return LIBRARIANS_LIST_PAGE;
    }
}
