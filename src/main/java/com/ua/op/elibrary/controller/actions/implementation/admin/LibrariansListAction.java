package com.ua.op.elibrary.controller.actions.implementation.admin;

import com.ua.op.elibrary.controller.actions.Action;
import com.ua.op.elibrary.model.dao.implementation.UserDAOImpl;
import com.ua.op.elibrary.model.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.List;

import static com.ua.op.elibrary.controller.actions.constants.Pages.*;

public class LibrariansListAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<User> librariansList = new UserDAOImpl().getAllByRoleID(2);
        request.setAttribute("librarians", librariansList);
        return LIBRARIANS_LIST_PAGE;
    }
}
