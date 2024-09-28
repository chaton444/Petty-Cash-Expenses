package com.example.tecops.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tecops.model.Gasto;

public interface IGastoRepository extends JpaRepository<Gasto, Integer> {
    // Método para encontrar gastos por ID de categoría
    List<Gasto> findByCategoria_IdCategoria(Integer idCategoria);
}
