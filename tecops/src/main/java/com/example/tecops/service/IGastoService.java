package com.example.tecops.service;

import java.util.List;


import com.example.tecops.model.Gasto;

public interface IGastoService {
    List<Gasto> listar();
    Gasto registrar(Gasto gasto);
    Gasto actualizar(Gasto gasto);
    void eliminar(Integer codigo);
    Gasto ListarPorId(Integer codigo);
}
