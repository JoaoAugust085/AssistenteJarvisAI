package com.jaugusto.AssistenteJarvisAI.controller;


import com.jaugusto.AssistenteJarvisAI.model.EventoModel;
import com.jaugusto.AssistenteJarvisAI.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoModel> listarEventoPorId(@PathVariable Long id){
        EventoModel evento = eventoService.listarEventoPorId(id);
        if(evento != null){
            return ResponseEntity.ok(evento);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EventoModel>> listarTodosEventos(){
        return ResponseEntity.ok(eventoService.listarTodosEventos());
    }

    @PostMapping
    public ResponseEntity<EventoModel> cadastrarEvento(@RequestBody EventoModel evento){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.cadastrarEvento(evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEventoPorId(@PathVariable Long id){
        eventoService.deletarEventoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoModel> atualizarEventoPorId(@PathVariable Long id, @RequestBody EventoModel eventoAtualizado){
        EventoModel evento = eventoService.atualizarEventoPorId(id, eventoAtualizado);
        if (evento != null){
            return ResponseEntity.ok(evento);
        }
        return ResponseEntity.notFound().build();
    }


}
