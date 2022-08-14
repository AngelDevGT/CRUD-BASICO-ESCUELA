package com.viaro.demo.service;

import com.viaro.demo.entity.Profesor;

import java.util.List;

public interface ProfesorService {

    Profesor saveProfesor(Profesor profesor);

    List<Profesor> getProfesorList();

    Profesor findProfesorById(Long profesorId);

    Profesor updateProfesor(Profesor profesor, Long profesorId);

    void deleteProfesor(Long profesorId);
}
