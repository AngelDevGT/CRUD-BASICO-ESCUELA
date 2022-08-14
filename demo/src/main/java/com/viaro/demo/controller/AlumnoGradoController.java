package com.viaro.demo.controller;

import com.viaro.demo.entity.AlumnoGrado;
import com.viaro.demo.service.AlumnoGradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoGradoController {

    @Autowired
    private AlumnoGradoService alumnoGradoService;

    @PostMapping("/alumnoGrado")
    public AlumnoGrado saveAlumnoGrado(@RequestBody AlumnoGrado alumnoGrado){
        return alumnoGradoService.saveAlumnoGrado(alumnoGrado);
    }

    @GetMapping("/alumnoGrados")
    public List<AlumnoGrado> getAllAlumnoGrado(){
        return alumnoGradoService.getAlumnoGradoList();
    }

    @GetMapping("/alumnoGrado/{id}")
    public AlumnoGrado findAlumnoGradoById(@PathVariable("id") Long id){
        return alumnoGradoService.findAlumnoGradoById(id);
    }

    @PutMapping("/alumnoGrado/{id}")
    public AlumnoGrado updateAlumnoGrado(@RequestBody AlumnoGrado alumnoGrado, @PathVariable("id") Long id){
        return alumnoGradoService.updateAlumnoGrado(alumnoGrado, id);
    }

    @DeleteMapping("/alumnoGrado/{id}")
    public void deleteAlumnoGrado(@PathVariable("id") Long id){
        alumnoGradoService.deleteAlumnoGrado(id);
    }
}
