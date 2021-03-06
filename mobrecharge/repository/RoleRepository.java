package com.dumbledore.mobrecharge.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dumbledore.mobrecharge.model.Role;
import com.dumbledore.mobrecharge.model.myenum.ERole;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
