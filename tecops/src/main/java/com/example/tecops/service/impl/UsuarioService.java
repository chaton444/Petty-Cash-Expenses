package com.example.tecops.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tecops.model.Usuario;
import com.example.tecops.repository.IUsuarioRepository; // Cambia esto por tu nombre de repositorio
import com.example.tecops.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private IUsuarioRepository repo;

    @Override
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public void eliminar(Integer codigo) {
        repo.deleteById(codigo);
    }

    @Override
    public Usuario ListarPorId(Integer codigo) {
        return repo.findById(codigo).orElse(null);
    }
}
