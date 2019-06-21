package com.excellenthealthSolution.pharmacy.general.security.dao;

import com.excellenthealthSolution.pharmacy.general.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface RoleDao extends JpaRepository<Role, Integer> {
}
