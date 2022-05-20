package com.TesteoV_1.TesteoV_1.security.repository;

import com.TesteoV_1.TesteoV_1.security.entity.Rol;
import com.TesteoV_1.TesteoV_1.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
