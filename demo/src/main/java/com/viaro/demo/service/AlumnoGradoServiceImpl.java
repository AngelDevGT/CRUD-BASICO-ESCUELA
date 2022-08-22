package com.viaro.demo.service;

import com.viaro.demo.entity.Alumno;
import com.viaro.demo.entity.AlumnoGrado;
import com.viaro.demo.entity.Grado;
import com.viaro.demo.exception.ResourceNotFoundException;
import com.viaro.demo.repository.AlumnoGradoRepository;
import com.viaro.demo.repository.AlumnoRepository;
import com.viaro.demo.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AlumnoGradoServiceImpl implements AlumnoGradoService {

    @Autowired
    private AlumnoGradoRepository alumnoGradoRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private GradoRepository gradoRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public AlumnoGrado saveAlumnoGrado(Long alumnoId, Long gradoId, String seccion) {
        Alumno alumno = alumnoRepository.findById(alumnoId).get();
        Grado grado = gradoRepository.findById(gradoId).get();

        AlumnoGrado newAlumnoGrado = new AlumnoGrado();
        newAlumnoGrado.setSeccion(seccion);
        newAlumnoGrado.setGradoId(grado);
        newAlumnoGrado.setAlumnoId(alumno);

        return alumnoGradoRepository.save(newAlumnoGrado);
    }

    @Override
    public AlumnoGrado findAlumnoGradoById(Long alumnoGradoId){
        return alumnoGradoRepository.findById(alumnoGradoId).get();
    }

    @Override
    public List<Grado> findGradoByAlumnoId(Long alumnoId){
        if (!alumnoRepository.existsById(alumnoId)){
            throw new ResourceNotFoundException("El alumno no existe con el id = " + alumnoId);
        }

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Grado> criteriaQuery = criteriaBuilder.createQuery(Grado.class);

        Root<AlumnoGrado> alumnoGradoRoot = criteriaQuery.from(AlumnoGrado.class);
        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.select(alumnoGradoRoot.get("gradoId"));

        predicates.add(criteriaBuilder.equal(alumnoGradoRoot.get("alumnoId").get("id"), alumnoId));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<AlumnoGrado> getAlumnoGradoList() {
        return (List<AlumnoGrado>) alumnoGradoRepository.findAll();
    }

    @Override
    public AlumnoGrado updateAlumnoGrado(AlumnoGrado alumnoGrado, Long alumnoGradoId) {

        AlumnoGrado alumnoGradoFound = alumnoGradoRepository.findById(alumnoGradoId).get();

        if (Objects.nonNull(alumnoGrado.getAlumnoId())) {
            alumnoGradoFound.setAlumnoId(alumnoGrado.getAlumnoId());
        }

        if (Objects.nonNull(alumnoGrado.getGradoId())) {
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
