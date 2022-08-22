package com.viaro.demo.repository;

import com.viaro.demo.entity.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long> {

}
