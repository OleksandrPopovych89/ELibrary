package com.ua.op.elibrary.model.entities;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(of = {"bookID", "ISBN"})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private long bookID;
    private String bookTitle;
    private String authorName;
    private String publisherName;
    private String ISBN;
    private int dateOfPublication;
    private int quantity;
}
