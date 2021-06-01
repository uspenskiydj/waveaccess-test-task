package com.waveaccess.waveaccesstesttask.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    SPEAKER,
    LISTENER;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}