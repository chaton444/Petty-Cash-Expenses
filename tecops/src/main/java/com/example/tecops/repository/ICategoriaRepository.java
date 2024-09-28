package com.example.tecops.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tecops.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Métodos personalizados se pueden agregar aquí
    // Método para encontrar categorías por nombre
    List<Categoria> findByNombre(String nombre);
}
