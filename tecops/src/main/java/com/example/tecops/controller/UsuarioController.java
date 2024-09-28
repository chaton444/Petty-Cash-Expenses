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

import com.example.tecops.model.Usuario;
import com.example.tecops.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> obj = service.listar();
        return new ResponseEntity<List<Usuario>>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@RequestBody Usuario usuario) {
        Usuario obj = service.registrar(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Usuario> actualizar(@RequestBody Usuario usuario) {
        Usuario obj = service.actualizar(usuario);
        return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Usuario obj = service.ListarPorId(id);
        if (obj == null) {
            throw new Exception("No se encontró ID");
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Usuario obj = service.ListarPorId(id);
        if (obj == null) {
            throw new Exception("No se encontró ID");
        }
        return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
    }
}
