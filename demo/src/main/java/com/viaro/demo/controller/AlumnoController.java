package com.viaro.demo.controller;

import com.viaro.demo.entity.Alumno;
import com.viaro.demo.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/alumno")
    public Alumno saveAlumno(@RequestBody Alumno alumno){
        return alumnoService.saveAlumno(alumno);
    }

    @GetMapping("/alumnos")
    public List<Alumno> getAllAlumnos(){
        return  alumnoService.getAlumnoList();
    }

    @GetMapping("/alumno/{id}")
    public Alumno findAlumnoById(@PathVariable("id") Long alumnoId){
        return alumnoService.findAlumnoById(alumnoId);
    }

    @PutMapping("/alumno/{id}")
    public Alumno updateAlumno(@RequestBody Alumno alumno, @PathVariable("id") Long alumnoId){
        return alumnoService.updateAlumno(alumno, alumnoId);
    }

    @DeleteMapping("/alumno/{id}")
    public void deleteAlumno(@PathVariable("id") Long alumnoId){
        alumnoService.deleteAlumno(alumnoId);
    }
}
