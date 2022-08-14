package com.viaro.demo.service;

import com.viaro.demo.entity.AlumnoGrado;

import java.util.List;

public interface AlumnoGradoService {

    AlumnoGrado saveAlumnoGrado(AlumnoGrado alumno);

    AlumnoGrado findAlumnoGradoById(Long alumnoGradoId);

    List<AlumnoGrado> getAlumnoGradoList();

    AlumnoGrado updateAlumnoGrado(AlumnoGrado alumnoGrado, Long alumnoGradoId);

    void deleteAlumnoGrado(Long alumnoGradoId);
}
