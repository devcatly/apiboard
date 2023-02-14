package com.apiboard.repository.member;


import com.apiboard.exception.member.Role;
import com.apiboard.exception.member.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}
