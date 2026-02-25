package com.jaugusto.AssistenteJarvisAI.service;

import com.jaugusto.AssistenteJarvisAI.model.UsuarioModel;
import com.jaugusto.AssistenteJarvisAI.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel listarUsuarioPorId(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<UsuarioModel> listarTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    public UsuarioModel cadastrarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuarioPorId(Long id){
        usuarioRepository.deleteById(id);
    }

    public UsuarioModel atualizarUsuarioPorId(Long id, UsuarioModel usuarioAtualizado){
        Optional<UsuarioModel> usuarioAtual = usuarioRepository.findById(id);
        if (usuarioAtual.isEmpty()){
            return null;
        }
        usuarioAtualizado.setId(usuarioAtual.get().getId());
        return usuarioRepository.save(usuarioAtualizado);
    }

}
