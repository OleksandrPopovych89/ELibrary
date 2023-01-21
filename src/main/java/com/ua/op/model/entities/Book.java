package com.ua.op.model.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"bookID", "ISBN"})
public class Book implements Serializable {
    private long bookID;
    private String bookTitle;
    private String authorName;
    private String publisherName;
    private String ISBN;
    private int dateOfPublication;
    private int quantity;
}
