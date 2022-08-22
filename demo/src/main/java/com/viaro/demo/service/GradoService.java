package com.viaro.demo.service;

import com.viaro.demo.entity.Grado;

import java.util.List;

public interface GradoService {

    Grado saveGrado(Long profesorId, String nombre);

    List<Grado> getGradoList();

    List<Grado> findGradoByProfesorId(Long profesorId);

    Grado findGradoById(Long gradoId);

    Grado updateGrado(Grado grado, Long gradoId);

    void deleteGrado(Long gradoId);
}
