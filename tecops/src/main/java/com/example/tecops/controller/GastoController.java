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

import com.example.tecops.model.Gasto;
import com.example.tecops.service.IGastoService;

@RestController
@RequestMapping("/gastos")
public class GastoController {
    @Autowired
    private IGastoService service;

    @GetMapping
    public ResponseEntity<List<Gasto>> listar() {
        List<Gasto> obj = service.listar();
        return new ResponseEntity<List<Gasto>>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@RequestBody Gasto gasto) {
        Gasto obj = service.registrar(gasto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGasto()).toUri();
        return ResponseEntity.created(uri).build();
    }
    

    @PutMapping
    public ResponseEntity<Gasto> actualizar(@RequestBody Gasto gasto) {
        Gasto obj = service.actualizar(gasto);
        return new ResponseEntity<Gasto>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Gasto obj = service.ListarPorId(id);
        if (obj == null) {
            throw new Exception("No se encontró ID");
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gasto> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Gasto obj = service.ListarPorId(id);
        if (obj == null) {
            throw new Exception("No se encontró ID");
        }
        return new ResponseEntity<Gasto>(obj, HttpStatus.OK);
    }
}
