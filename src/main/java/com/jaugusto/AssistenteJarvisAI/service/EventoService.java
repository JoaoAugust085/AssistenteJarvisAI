package com.jaugusto.AssistenteJarvisAI.service;


import com.jaugusto.AssistenteJarvisAI.model.EventoModel;
import com.jaugusto.AssistenteJarvisAI.repository.EventoRepository;
import com.jaugusto.AssistenteJarvisAI.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;

    }

    public EventoModel listarEventoPorId(Long id){
        return eventoRepository.findById(id).orElse(null);
    }

    public List<EventoModel> listarTodosEventos(){
        return eventoRepository.findAll();
    }

    public EventoModel cadastrarEvento(EventoModel evento){
        return eventoRepository.save(evento);
    }

    public void deletarEventoPorId(Long id){
        eventoRepository.deleteById(id);
    }

    public EventoModel atualizarEventoPorId(Long id, EventoModel eventoAtualizado){
        Optional<EventoModel> eventoAtual = eventoRepository.findById(id);
        if(eventoAtual.isEmpty()){
            return null;
        }
        eventoAtualizado.setId(eventoAtual.get().getId());
        return eventoRepository.save(eventoAtualizado);
    }




}
