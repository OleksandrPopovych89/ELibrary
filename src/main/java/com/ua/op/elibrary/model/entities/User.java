package com.ua.op.elibrary.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private long userId;
    private String user_Login;
    private transient String user_Password;
    private String userFirstname;
    private String userLastname;
    @EqualsAndHashCode.Exclude
    private Role role;
    private boolean isBlocked;
}
