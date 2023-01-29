package com.ua.op.elibrary.model.entities;

import com.ua.op.elibrary.model.entities.enums.Role;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(of = {"userId", "userEmail",
        "userPassword", "userPhoneNumber", "userFirstname", "userLastname"})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private long userId;
    private String userEmail;
    private transient String userPassword;
    private String userPhoneNumber;
    private String userFirstname;
    private String userLastname;
    private int userRole;
    private boolean isBlocked;
}
