package com.jaugusto.AssistenteJarvisAI.repository;

import com.jaugusto.AssistenteJarvisAI.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
