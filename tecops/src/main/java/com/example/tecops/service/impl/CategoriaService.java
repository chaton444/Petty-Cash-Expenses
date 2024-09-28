package com.example.tecops.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tecops.model.Categoria;
import com.example.tecops.repository.ICategoriaRepository; // Cambia esto por tu nombre de repositorio
import com.example.tecops.service.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService {
    
    @Autowired
    private ICategoriaRepository repo;

    @Override
    public List<Categoria> listar() {
        return repo.findAll();
    }

    @Override
    public Categoria registrar(Categoria categoria) {
        return repo.save(categoria);
    }

    @Override
    public Categoria actualizar(Categoria categoria) {
        return repo.save(categoria);
    }

    @Override
    public void eliminar(Integer codigo) {
        repo.deleteById(codigo);
    }

    @Override
    public Categoria ListarPorId(Integer codigo) {
        return repo.findById(codigo).orElse(null);
    }
}
