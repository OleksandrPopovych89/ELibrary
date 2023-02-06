package com.ua.op.elibrary.controller.actions.implementation.admin;

import com.ua.op.elibrary.controller.actions.Action;
import com.ua.op.elibrary.model.dao.implementation.UserDAOImpl;
import com.ua.op.elibrary.model.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.List;

import static com.ua.op.elibrary.controller.actions.constants.Pages.*;

public class ReadersListAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<User> readerList = new UserDAOImpl().getAllByRoleID(3);
        request.setAttribute("readers", readerList);
        return READER_LIST_PAGE;
    }
}
