package com.ua.op.elibrary.controller.actions.implementation.general;

import com.ua.op.elibrary.controller.actions.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static com.ua.op.elibrary.controller.actions.constants.Pages.*;

public class CreateUserFormAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        return CREATE_USER_FORM_PAGE;
    }
}
