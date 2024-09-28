package com.example.tecops.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.tecops.model.Categoria;
import com.example.tecops.service.ICategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private ICategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        List<Categoria> obj = service.listar();
        return new ResponseEntity<List<Categoria>>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@RequestBody Categoria categoria) {
        Categoria obj = service.registrar(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCategoria()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Categoria> actualizar(@RequestBody Categoria categoria) {
        Categoria obj = service.actualizar(categoria);
        return new ResponseEntity<Categoria>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Categoria obj = service.ListarPorId(id);
        if (obj == null) {
            throw new Exception("No se encontró ID");
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Categoria obj = service.ListarPorId(id);
        if (obj == null) {
            throw new Exception("No se encontró ID");
        }
        return new ResponseEntity<Categoria>(obj, HttpStatus.OK);
    }
}

