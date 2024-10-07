package com.uissurvey.uissurvey_app.infrastructure.repositories.user;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uissurvey.uissurvey_app.domain.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
