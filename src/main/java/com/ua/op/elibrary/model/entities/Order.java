package com.ua.op.elibrary.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode(of = {"orderId", "bookId", "userId", "subscriptionType"})
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private int orderId;
    private int bookId;
    private int userId;
    private int subscriptionType;
    private int orderStatusId;
    private LocalDate orderCreateTime;
    private LocalDate returnDeadline;
}
