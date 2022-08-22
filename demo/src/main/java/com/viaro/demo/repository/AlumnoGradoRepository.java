package com.viaro.demo.repository;

import com.viaro.demo.entity.AlumnoGrado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AlumnoGradoRepository extends JpaRepository<AlumnoGrado, Long> {

}
