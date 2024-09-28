package com.example.tecops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.tecops.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    // Método para encontrar usuarios por rol
    List<Usuario> findByRol(String rol);
}
