package com.viaro.demo.service;

import com.viaro.demo.entity.AlumnoGrado;
import com.viaro.demo.entity.Grado;

import java.util.List;

public interface AlumnoGradoService {

    AlumnoGrado saveAlumnoGrado(Long alumnoId, Long gradoId, String seccion);

    AlumnoGrado findAlumnoGradoById(Long alumnoGradoId);

    List<AlumnoGrado> getAlumnoGradoList();

    List<Grado> findGradoByAlumnoId(Long alumnoId);

    AlumnoGrado updateAlumnoGrado(AlumnoGrado alumnoGrado, Long alumnoGradoId);

    void deleteAlumnoGrado(Long alumnoGradoId);
}
