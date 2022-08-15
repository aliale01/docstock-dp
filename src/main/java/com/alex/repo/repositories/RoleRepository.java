package com.alex.repo.repositories;

import com.alex.repo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    //Role findByRoleName(String name);
}
