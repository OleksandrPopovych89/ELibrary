package com.ua.op.elibrary.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private long userId;
    private String userEmail;
    private transient String userPassword;
    private String  userPhoneNumber;
    private String userFirstname;
    private String userLastname;
    @EqualsAndHashCode.Exclude
    private Role userRole;
    private boolean isBlocked;
}
