//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.controller;

import com.example.apiMecanico.conserto.Conserto;
import com.example.apiMecanico.conserto.ConsertoDTO;
import com.example.apiMecanico.conserto.ConsertoRepository;
import com.example.apiMecanico.especiais.AtualizacaoConsertoDTO;
import com.example.apiMecanico.especiais.ConsertoEspecificoDTO;
import com.example.apiMecanico.especiais.DetalhesConsertoDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("conserto")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ConsertoDTO dados, UriComponentsBuilder uriBuilder){
        Conserto conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body( new DetalhesConsertoDTO(conserto));
    }

    @GetMapping
    public Page<Conserto> listar(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping
    @RequestMapping("dadosespecificos")
    public List<ConsertoEspecificoDTO> listarDadosEspecificos(Pageable page){
        return repository.findAllByAtivoTrue(page).stream().map(ConsertoEspecificoDTO::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id){
        Optional<Conserto> consertoOptional = repository.findById(id);
        if(consertoOptional.isPresent()){
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DetalhesConsertoDTO(conserto));
        }else{
            return ResponseEntity.notFound().build();
        }


    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoConsertoDTO dados){
        Conserto conserto = repository.getReferenceById( dados.id() );
        conserto.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DetalhesConsertoDTO(conserto));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }

}
