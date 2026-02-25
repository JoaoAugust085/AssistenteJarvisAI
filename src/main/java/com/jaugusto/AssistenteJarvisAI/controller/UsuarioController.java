package com.jaugusto.AssistenteJarvisAI.controller;

import com.jaugusto.AssistenteJarvisAI.model.UsuarioModel;
import com.jaugusto.AssistenteJarvisAI.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //GET
    @GetMapping("/listar/{id}")
    public ResponseEntity<UsuarioModel> listarUsuarioPorId(@PathVariable Long id){
        UsuarioModel usuario = usuarioService.listarUsuarioPorId(id);
        if (usuario != null){
            return ResponseEntity.ok(usuario);
        }

            return ResponseEntity.notFound().build();
    }

    //GET
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioModel>> listarTodosUsuarios(){
        return ResponseEntity.ok(usuarioService.listarTodosUsuarios());
    }

    //POST
    @PostMapping("cadastrar")
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody UsuarioModel usuario){
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuario));
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuarioPorId(@PathVariable Long id){
    usuarioService.deletarUsuarioPorId(id);
    }

    //UPDATE
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioModel> atualizarUsuarioPorId(@PathVariable Long id, @RequestBody UsuarioModel usuarioAtualizado){
        UsuarioModel usuario = usuarioService.atualizarUsuarioPorId( id, usuarioAtualizado);
        if (usuario != null){
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();

    }


}
