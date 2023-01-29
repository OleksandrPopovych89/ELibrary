package com.ua.op.elibrary.controller.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;

public interface Action {
    String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException;
}
