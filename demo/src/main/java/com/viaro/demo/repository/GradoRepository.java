package com.viaro.demo.repository;

import com.viaro.demo.entity.Grado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradoRepository extends CrudRepository<Grado, Long> {
}
