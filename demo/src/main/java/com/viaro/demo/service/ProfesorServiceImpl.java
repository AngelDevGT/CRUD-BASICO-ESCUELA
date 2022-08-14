package com.viaro.demo.service;

import com.viaro.demo.entity.Profesor;
import com.viaro.demo.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfesorServiceImpl implements  ProfesorService{

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public Profesor saveProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor findProfesorById(Long profesorId){
        return profesorRepository.findById(profesorId).get();
    }

    @Override
    public List<Profesor> getProfesorList(){
        return (List<Profesor>)profesorRepository.findAll();
    }

    @Override
    public Profesor updateProfesor(Profesor profesor, Long profesorId){
        Profesor profesorFound = profesorRepository.findById(profesorId).get();

        if (Objects.nonNull(profesor.getApellido()) && !"".equalsIgnoreCase(profesor.getApellido())) {
            profesorFound.setApellido(profesor.getApellido());
        }

        if (Objects.nonNull(profesor.getGenero()) && !"".equalsIgnoreCase(profesor.getGenero())) {
            profesorFound.setGenero(profesor.getGenero());
        }

        if (Objects.nonNull(profesor.getNombre()) && !"".equalsIgnoreCase(profesor.getNombre())) {
            profesorFound.setNombre(profesor.getNombre());
        }

        return profesorRepository.save(profesorFound);
    }

    @Override
    public void deleteProfesor(Long profesorId){
        profesorRepository.deleteById(profesorId);
    }
}
