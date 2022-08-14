package com.viaro.demo.repository;

import com.viaro.demo.entity.AlumnoGrado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoGradoRepository extends CrudRepository<AlumnoGrado, Long> {
}
