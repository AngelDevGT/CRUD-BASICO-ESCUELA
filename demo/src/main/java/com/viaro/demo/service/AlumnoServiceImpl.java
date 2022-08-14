package com.viaro.demo.service;

import com.viaro.demo.entity.Alumno;
import com.viaro.demo.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno findAlumnoById(Long alumnoId){
        return alumnoRepository.findById(alumnoId).get();
    }

    @Override
    public List<Alumno> getAlumnoList() {
        return (List<Alumno>) alumnoRepository.findAll();
    }

    @Override
    public Alumno updateAlumno(Alumno alumno, Long alumnoId) {
        Alumno alumnoFound = alumnoRepository.findById(alumnoId).get();

        if (Objects.nonNull(alumno.getNombre()) && !"".equalsIgnoreCase(alumno.getNombre())) {
            alumnoFound.setNombre(alumno.getNombre());
        }

        if (Objects.nonNull(alumno.getApellido()) && !"".equalsIgnoreCase(alumno.getApellido())) {
            alumnoFound.setApellido(alumno.getApellido());
        }

        if (Objects.nonNull(alumno.getGenero()) && !"".equalsIgnoreCase(alumno.getGenero())) {
            alumnoFound.setGenero(alumno.getGenero());
        }

        if (Objects.nonNull(alumno.getFechaNacimiento()) && !"".equalsIgnoreCase(alumno.getFechaNacimiento())) {
            alumnoFound.setFechaNacimiento(alumno.getFechaNacimiento());
        }

        return alumnoRepository.save(alumnoFound);
    }

    @Override
    public void deleteAlumno(Long alumnoId) {
        alumnoRepository.deleteById(alumnoId);
    }
}
