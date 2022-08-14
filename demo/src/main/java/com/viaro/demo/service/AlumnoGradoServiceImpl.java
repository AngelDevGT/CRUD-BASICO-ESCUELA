package com.viaro.demo.service;

import com.viaro.demo.entity.AlumnoGrado;
import com.viaro.demo.repository.AlumnoGradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AlumnoGradoServiceImpl implements AlumnoGradoService {

    @Autowired
    private AlumnoGradoRepository alumnoGradoRepository;

    @Override
    public AlumnoGrado saveAlumnoGrado(AlumnoGrado alumnoGrado) {
        return alumnoGradoRepository.save(alumnoGrado);
    }

    @Override
    public AlumnoGrado findAlumnoGradoById(Long alumnoGradoId){
        return alumnoGradoRepository.findById(alumnoGradoId).get();
    }

    @Override
    public List<AlumnoGrado> getAlumnoGradoList() {
        return (List<AlumnoGrado>) alumnoGradoRepository.findAll();
    }

    @Override
    public AlumnoGrado updateAlumnoGrado(AlumnoGrado alumnoGrado, Long alumnoGradoId) {

        AlumnoGrado alumnoGradoFound = alumnoGradoRepository.findById(alumnoGradoId).get();

        if (Objects.nonNull(alumnoGrado.getAlumnoId()) && alumnoGrado.getAlumnoId() > 0) {
            alumnoGradoFound.setAlumnoId(alumnoGrado.getAlumnoId());
        }

        if (Objects.nonNull(alumnoGrado.getGradoId()) && alumnoGrado.getGradoId() > 0) {
            alumnoGradoFound.setGradoId(alumnoGrado.getGradoId());
        }

        if (Objects.nonNull(alumnoGrado.getSeccion()) && !"".equalsIgnoreCase(alumnoGrado.getSeccion())) {
            alumnoGradoFound.setSeccion(alumnoGrado.getSeccion());
        }

        return alumnoGradoRepository.save(alumnoGradoFound);
    }

    @Override
    public void deleteAlumnoGrado(Long alumnoGradoId) {
        alumnoGradoRepository.deleteById(alumnoGradoId);
    }
}
