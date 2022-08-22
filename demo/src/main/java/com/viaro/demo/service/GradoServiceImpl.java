package com.viaro.demo.service;

import com.viaro.demo.entity.Grado;
import com.viaro.demo.entity.Profesor;
import com.viaro.demo.exception.ResourceNotFoundException;
import com.viaro.demo.repository.GradoRepository;
import com.viaro.demo.repository.ProfesorRepository;
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
public class GradoServiceImpl implements GradoService {

    @Autowired
    private GradoRepository gradoRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Grado saveGrado(Long profesorId, String nombre) {
        Profesor profesor = profesorRepository.findById(profesorId).get();

        Grado newGrado = new Grado();
        newGrado.setNombre(nombre);
        newGrado.setProfesorId(profesor);

        return gradoRepository.save(newGrado);
    }

    @Override
    public Grado findGradoById(Long gradoId) {
        return gradoRepository.findById(gradoId).get();
    }

    @Override
    public List<Grado> getGradoList() {
        return gradoRepository.findAll();
    }

    @Override
    public List<Grado> findGradoByProfesorId(Long profesorId) {
        if (!profesorRepository.existsById(profesorId)) {
            throw new ResourceNotFoundException("El profesor no exite con el id = " + profesorId);
        }

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Grado> criteriaQuery = criteriaBuilder.createQuery(Grado.class);

        Root<Grado> gradoRoot = criteriaQuery.from(Grado.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(gradoRoot.get("profesorId").get("id"), profesorId));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Grado updateGrado(Grado grado, Long gradoId) {
        Grado gradoFound = gradoRepository.findById(gradoId).get();

        if (Objects.nonNull(grado.getNombre()) && !"".equalsIgnoreCase(grado.getNombre())) {
            gradoFound.setNombre(grado.getNombre());
        }

        if (Objects.nonNull(grado.getProfesorId())) {
            gradoFound.setProfesorId(grado.getProfesorId());
        }

        return gradoRepository.save(gradoFound);
    }

    @Override
    public void deleteGrado(Long gradoId) {
        gradoRepository.deleteById(gradoId);
    }
}
