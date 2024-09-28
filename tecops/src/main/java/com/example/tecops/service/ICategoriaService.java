package com.example.tecops.service;

import java.util.List;
import com.example.tecops.model.Categoria;

public interface ICategoriaService {
    List<Categoria> listar();
    Categoria registrar(Categoria categoria);
    Categoria actualizar(Categoria categoria);
    void eliminar(Integer codigo);
    Categoria ListarPorId(Integer codigo);
}

