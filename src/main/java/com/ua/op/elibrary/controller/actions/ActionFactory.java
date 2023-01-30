package com.ua.op.elibrary.controller.actions;


import com.ua.op.elibrary.controller.actions.implementation.admin.LibrariansListAction;
import com.ua.op.elibrary.controller.actions.implementation.admin.OrdersListAction;
import com.ua.op.elibrary.controller.actions.implementation.admin.UsersListAction;
import com.ua.op.elibrary.controller.actions.implementation.general.DefaultAction;
import com.ua.op.elibrary.controller.actions.implementation.info.AboutAction;
import com.ua.op.elibrary.controller.actions.implementation.general.BooksListAction;
import com.ua.op.elibrary.controller.actions.implementation.info.ContactsAction;

import java.util.HashMap;
import java.util.Map;


import static com.ua.op.elibrary.controller.actions.constants.ActionNames.*;

public final class ActionFactory {
    private static final ActionFactory ACTION_FACTORY = new ActionFactory();
    private static final Map<String, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(DEFAULT_ACTION, new DefaultAction());
        ACTION_MAP.put(ABOUT_ACTION, new AboutAction());
        ACTION_MAP.put(CONTACTS_ACTION, new ContactsAction());
        ACTION_MAP.put(BOOKS_LIST_ACTIONS, new BooksListAction());

        ACTION_MAP.put(LIBRARIANS_LIST_ACTIONS, new LibrariansListAction());
        ACTION_MAP.put(USERS_LIST_ACTIONS, new UsersListAction());

        ACTION_MAP.put(USERS_LIST_ACTIONS, new OrdersListAction());
    }

    private ActionFactory() {
    }

    public static ActionFactory getActionFactory() {
        return ACTION_FACTORY;
    }

    public Action createAction(String actionName) {
        return ACTION_MAP.getOrDefault(actionName, new DefaultAction());
    }
}
