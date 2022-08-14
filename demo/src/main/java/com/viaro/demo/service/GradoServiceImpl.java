package com.viaro.demo.service;

import com.viaro.demo.entity.Grado;
import com.viaro.demo.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GradoServiceImpl implements GradoService {

    @Autowired
    private GradoRepository gradoRepository;

    @Override
    public Grado saveGrado(Grado grado){
        return gradoRepository.save(grado);
    }

    @Override
    public Grado findGradoById(Long gradoId){
        return gradoRepository.findById(gradoId).get();
    }

    @Override
    public List<Grado> getGradoList(){
        return (List<Grado>) gradoRepository.findAll();
    }

    @Override
    public Grado updateGrado(Grado grado, Long gradoId){
        Grado gradoFound = gradoRepository.findById(gradoId).get();

        if (Objects.nonNull(grado.getNombre()) && !"".equalsIgnoreCase(grado.getNombre())) {
            gradoFound.setNombre(grado.getNombre());
        }

        if (Objects.nonNull(grado.getProfesorId()) && grado.getProfesorId() > 0) {
            gradoFound.setProfesorId(grado.getProfesorId());
        }

        return gradoRepository.save(gradoFound);
    }

    @Override
    public void deleteGrado(Long gradoId){
        gradoRepository.deleteById(gradoId);
    }
}
