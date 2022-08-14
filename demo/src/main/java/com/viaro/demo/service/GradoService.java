package com.viaro.demo.service;

import com.viaro.demo.entity.Grado;

import java.util.List;

public interface GradoService {

    Grado saveGrado(Grado grado);

    List<Grado> getGradoList();

    Grado findGradoById(Long gradoId);

    Grado updateGrado(Grado grado, Long gradoId);

    void deleteGrado(Long gradoId);
}
