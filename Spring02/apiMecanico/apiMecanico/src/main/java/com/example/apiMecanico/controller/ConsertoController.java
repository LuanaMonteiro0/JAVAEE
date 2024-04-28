//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.controller;

import com.example.apiMecanico.conserto.Conserto;
import com.example.apiMecanico.conserto.ConsertoDTO;
import com.example.apiMecanico.conserto.ConsertoRepository;
import com.example.apiMecanico.especiais.ConsertoEspecificoDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conserto")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ConsertoDTO dados){
        repository.save(new Conserto(dados));
    }

    @GetMapping
    public Page<Conserto> listar(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping
    @RequestMapping("dadosespecificos")
    public List<ConsertoEspecificoDTO> listarDadosEspecificos(){
        return repository.findAll().stream().map(ConsertoEspecificoDTO::new).toList();
    }

}
