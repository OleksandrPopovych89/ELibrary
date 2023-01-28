package com.ua.op.elibrary.controller.actions.implementation.info;

import com.ua.op.elibrary.controller.actions.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.ua.op.elibrary.controller.actions.constants.Pages.ABOUT_PAGE;

public class AboutAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return ABOUT_PAGE;
    }
}
