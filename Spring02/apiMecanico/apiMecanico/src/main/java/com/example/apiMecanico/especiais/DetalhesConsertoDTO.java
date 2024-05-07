package com.example.apiMecanico.especiais;

import com.example.apiMecanico.conserto.Conserto;
import com.example.apiMecanico.mecanico.Mecanico;
import com.example.apiMecanico.veiculo.Veiculo;

public record DetalhesConsertoDTO(
        String dataEntradaOficina,
        String dataSaidaOficina,
        Mecanico mecanicoResponsavel,
        Veiculo veiculo) {
    public DetalhesConsertoDTO(Conserto c){
        this(c.getDataEntradaOficina(), c.getDataSaidaOficina(), c.getMecanicoResponsavel(),c.getVeiculo());
    }
}
