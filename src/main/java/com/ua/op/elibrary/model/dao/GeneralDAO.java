package com.ua.op.elibrary.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<T> {
    void add(T t) throws SQLException;

    List<T> getAll() throws SQLException;

    void update(T t) throws SQLException;

    void delete(long id) throws SQLException;
}
