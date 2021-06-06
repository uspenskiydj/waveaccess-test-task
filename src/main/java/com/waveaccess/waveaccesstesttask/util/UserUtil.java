package com.waveaccess.waveaccesstesttask.util;

import com.waveaccess.waveaccesstesttask.model.User;
import com.waveaccess.waveaccesstesttask.security.SecurityConfig;
import org.springframework.util.StringUtils;

public class UserUtil {

    public static User prepareToSave(User user) {
        String password = user.getPassword();
        user.setPassword(StringUtils.hasText(password) ? SecurityConfig.passwordEncoder().encode(password) : password);
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
