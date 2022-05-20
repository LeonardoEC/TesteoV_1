package com.TesteoV_1.TesteoV_1.controlador;

import com.TesteoV_1.TesteoV_1.execpciones.ResourceNotFoundException;
import com.TesteoV_1.TesteoV_1.modelo.Curso;
import com.TesteoV_1.TesteoV_1.repositorio.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ap1/v1")
@CrossOrigin
public class CursoControlador {

    @Autowired
    private CursoRepositorio repositorio;

    //lista
    @GetMapping("/cursos")
    public List<Curso> listaDeCursos(){
        return repositorio.findAll();
    }

    //crear
    @PostMapping("/cursos")
    public Curso guardarCurso(@RequestBody Curso curso){
        return repositorio.save(curso);
    }

    //obtener
    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> obtenerCurso(@PathVariable Long id){
        Curso curso = repositorio.findById(id) .orElseThrow(()-> new ResourceNotFoundException("No existe el curso con el ID: " + id));
        return ResponseEntity.ok(curso);
    }

    //actualizar
    @PutMapping("/cursos/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso detallesCursos){
        Curso curso = repositorio.findById(id) .orElseThrow(()-> new ResourceNotFoundException("No existe el curso con el ID: " + id));

        curso.setNombre(detallesCursos.getNombre());
        curso.setLugar(detallesCursos.getLugar());
        curso.setFechainicio(detallesCursos.getFechainicio());
        curso.setFechafin(detallesCursos.getFechafin());
        curso.setDescripcion(detallesCursos.getDescripcion());
        curso.setImgUrl(detallesCursos.getImgUrl());

        Curso cursoActualizado = repositorio.save(curso);
        return ResponseEntity.ok(cursoActualizado);
    }

    //eliminar
    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCurso(@PathVariable Long id){
        Curso curso = repositorio.findById(id) .orElseThrow(()-> new ResourceNotFoundException("No existe el curso con el ID: " + id));

        repositorio.delete(curso);
        Map<String,Boolean> repuesta = new HashMap<>();
        return ResponseEntity.ok(repuesta);
    }
}
