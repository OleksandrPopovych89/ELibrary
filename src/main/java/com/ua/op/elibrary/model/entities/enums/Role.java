package com.ua.op.elibrary.model.entities.enums;

public enum Role {
    ADMIN(1), LIBRARIAN(2), READER(3);
    private final int value;

    Role(int value) {
        this.value = value;
    }

    public static Role getRole(int value) {
        for (Role role : Role.values()) {
            if (role.value == value) {
                return role;
            }
        }
        return READER;
    }
}
