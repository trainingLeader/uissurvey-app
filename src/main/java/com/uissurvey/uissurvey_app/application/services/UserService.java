package com.uissurvey.uissurvey_app.application.services;

import java.util.List;

import com.uissurvey.uissurvey_app.domain.entities.User;

public interface UserService {
    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);
}
