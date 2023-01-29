package com.ua.op.elibrary.model.entities.enums;

public enum SubscriptionType {
    SUBSCRIPTION(1), READING_ROOM(2);
    private final int value;

    SubscriptionType(int value) {
        this.value = value;
    }

    public static SubscriptionType getSubscriptionType(int value) {
        for (SubscriptionType type : SubscriptionType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return SUBSCRIPTION;
    }
}
