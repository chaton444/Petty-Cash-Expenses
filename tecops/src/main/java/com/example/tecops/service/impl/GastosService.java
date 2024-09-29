package com.example.tecops.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tecops.model.Gasto;
import com.example.tecops.repository.IGastoRepository; // Cambia esto por tu nombre de repositorio
import com.example.tecops.service.IGastoService;

@Service
public class GastosService implements IGastoService {
    
    @Autowired
    private IGastoRepository repo;

    @Override
    public List<Gasto> listar() {
        return repo.findAll();
    }

    @Override
    public Gasto registrar(Gasto gasto) {
        return repo.save(gasto);
    }

    @Override
    public Gasto actualizar(Gasto gasto) {
        return repo.save(gasto);
    }

    @Override
    public void eliminar(Integer codigo) {
        repo.deleteById(codigo);
    }

    @Override
    public Gasto ListarPorId(Integer codigo) {
        return repo.findById(codigo).orElse(null);
    }
    
}

