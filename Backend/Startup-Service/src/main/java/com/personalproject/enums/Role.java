package com.personalproject.enums;

public enum Role {
    STARTUP, INVESTOR;

    public String getRoleName() {
        return this.name();
    }
}