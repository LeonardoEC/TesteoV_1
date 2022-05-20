package com.TesteoV_1.TesteoV_1.controlador;

import com.TesteoV_1.TesteoV_1.execpciones.ResourceNotFoundException;
import com.TesteoV_1.TesteoV_1.modelo.Trabajo;
import com.TesteoV_1.TesteoV_1.repositorio.TrabajoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class TrabajoControlador {

    @Autowired
    private TrabajoRepositorio repositorio;

    @GetMapping("/trabajos")
    public List<Trabajo> listaDeTrabajos(){
        return repositorio.findAll();
    }

    @PostMapping("/trabajos")
    public Trabajo guardarTrabajo(@RequestBody Trabajo trabajo){
        return repositorio.save(trabajo);
    }

    @GetMapping("/trabajos/{id}")
    public ResponseEntity<Trabajo> obtenerTrabajo(@PathVariable Long id){
        Trabajo trabajo = repositorio.findById(id) .orElseThrow(()-> new ResourceNotFoundException("No existe el trabajo con el ID: "+id));
        return ResponseEntity.ok(trabajo);
    }

    @PutMapping("/trabajos/{id}")
    public ResponseEntity<Trabajo> actualizarTrabajo(@PathVariable Long id, @RequestBody Trabajo detallesTrabajo){
        Trabajo trabajo = repositorio.findById(id) .orElseThrow(()-> new ResourceNotFoundException("No existe el trabajo con el ID: "+id));

        trabajo.setNombre(detallesTrabajo.getNombre());
        trabajo.setPuesto(detallesTrabajo.getPuesto());
        trabajo.setDescripcion(detallesTrabajo.getDescripcion());
        trabajo.setImgUrl(detallesTrabajo.getImgUrl());

        trabajo.setEmpleador(detallesTrabajo.getEmpleador());
        trabajo.setTelefono(detallesTrabajo.getTelefono());

        Trabajo trabajoActualizado = repositorio.save(trabajo);
        return  ResponseEntity.ok(trabajoActualizado);
    }

    @DeleteMapping("/trabajos/{id}")
    public  ResponseEntity<Map<String,Boolean>> eliminarTrabajo(@PathVariable Long id){
        Trabajo trabajo = repositorio.findById(id) .orElseThrow(()-> new ResourceNotFoundException("No existe el trabajo con el ID: "+id));

        repositorio.delete(trabajo);
        Map<String,Boolean> respuesta = new HashMap<>();
        return ResponseEntity.ok(respuesta);
    }
}
