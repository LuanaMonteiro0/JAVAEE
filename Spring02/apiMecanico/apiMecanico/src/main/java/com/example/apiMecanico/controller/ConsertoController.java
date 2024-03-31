//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.controller;

import com.example.apiMecanico.conserto.Conserto;
import com.example.apiMecanico.conserto.ConsertoDTO;
import com.example.apiMecanico.conserto.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conserto")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody ConsertoDTO dados){
        repository.save(new Conserto(dados));
    }
}
