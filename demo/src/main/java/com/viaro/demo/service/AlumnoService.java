package com.viaro.demo.service;

import com.viaro.demo.entity.Alumno;

import java.util.List;

public interface AlumnoService {

    Alumno saveAlumno(Alumno alumno);

    List<Alumno> getAlumnoList();

    Alumno findAlumnoById(Long alumnoId);

    Alumno updateAlumno(Alumno alumno, Long alumnoId);

    void deleteAlumno(Long alumnoId);
}
