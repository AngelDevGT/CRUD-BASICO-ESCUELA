package com.viaro.demo.controller;

import com.viaro.demo.entity.Profesor;
import com.viaro.demo.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/profesor")
    public Profesor saveProfesor(@RequestBody Profesor profesor) {
        return profesorService.saveProfesor(profesor);
    }

    @GetMapping("/profesores")
    public List<Profesor> getAllProfesores(){
        return profesorService.getProfesorList();
    }

    @GetMapping("/profesor/{id}")
    public Profesor findProfesorById(@PathVariable("id") Long id){
        return profesorService.findProfesorById(id);
    }

    @PutMapping("/profesor/{id}")
    public Profesor updateProfesor(@PathVariable("id") Long id, @RequestBody Profesor profesor) {
        return profesorService.updateProfesor(profesor, id);
    }

    @DeleteMapping("/profesor/{id}")
    public void deleteProfesor(@PathVariable("id") Long id) {
        profesorService.deleteProfesor(id);
    }
}
