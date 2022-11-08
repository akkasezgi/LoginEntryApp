package com.enoca.ezgiproject.repository;

import com.enoca.ezgiproject.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
