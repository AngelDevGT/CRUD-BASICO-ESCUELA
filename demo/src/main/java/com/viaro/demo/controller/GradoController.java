package com.viaro.demo.controller;

import com.viaro.demo.entity.Grado;
import com.viaro.demo.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradoController {

    @Autowired
    private GradoService gradoService;

    @PostMapping("/profesor/{id}/grado")
    public Grado saveGrado(@PathVariable("id") Long id, @RequestBody Grado grado) {
        return gradoService.saveGrado(id, grado.getNombre());
    }

    @GetMapping("/grados")
    public List<Grado> getAllGrados(){
        return gradoService.getGradoList();
    }

    @GetMapping("/grado/{id}")
    public Grado findGradoById(@PathVariable("id") Long id){
        return gradoService.findGradoById(id);
    }

    @GetMapping("/profesor/{id}/grado")
    public List<Grado> findGradoByProfesorId(@PathVariable("id") Long id){
        return gradoService.findGradoByProfesorId(id);
    }

    @PutMapping("/grado/{id}")
    public Grado updateGrado(@RequestBody Grado grado, @PathVariable("id") Long id){
        return gradoService.updateGrado(grado, id);
    }

    @DeleteMapping("/grado/{id}")
    public void DeleteGrado(@PathVariable("id") Long id) {
        gradoService.deleteGrado(id);
    }
}
