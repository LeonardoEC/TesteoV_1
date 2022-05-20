package com.TesteoV_1.TesteoV_1.repositorio;

import com.TesteoV_1.TesteoV_1.modelo.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepositorio extends JpaRepository<Trabajo, Long> {
}
