package com.ua.op.elibrary.model.dao.constants;

public  interface TableFields {
    /**Users table fields*/
    String USER_ID = "user_id";
    String USER_EMAIL = "user_email";
    String USER_PASSWORD = "user_password";
    String USER_PHONE_NUMBER = "user_pone_number";
    String USER_FIRSTNAME = "user_firstname";
    String USER_LASTNAME = "user_lastname";
    String USER_ROLE_ID = "user_role_id";
    String USER_IS_BLOCKED = "user_is_blocked";


    /**Books table fields*/
    String BOOK_ID = "book_id";
    String BOOK_TITLE = "book_title";
    String AUTHOR_NAME = "author_name";
    String PUBLISHER_NAME = "publisher_name";
    String ISBN = "isbn";
    String DATE_OF_PUBLICATION = "date_of_publication";
    String QUANTITY = "quantity";


}