package com.uissurvey.uissurvey_app.infrastructure.repositories.roles;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.uissurvey.uissurvey_app.domain.entities.Role;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
