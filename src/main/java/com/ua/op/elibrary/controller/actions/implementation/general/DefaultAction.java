package com.ua.op.elibrary.controller.actions.implementation.general;

import com.ua.op.elibrary.controller.actions.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.ua.op.elibrary.controller.actions.constants.Pages.INDEX_PAGE;

public class DefaultAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        return INDEX_PAGE;
    }
}