package com.example.apiMecanico.especiais;

import com.example.apiMecanico.conserto.Conserto;
import com.example.apiMecanico.mecanico.MecanicoDTO;
import com.example.apiMecanico.veiculo.VeiculoDTO;


public record ConsertoEspecificoDTO(
        Long id,
        String dataEntradaOficina,
        String dataSaidaOficina,
        String nomeMecanicoResponsavel,
        String veiculoMarca,
        String veiculoMondelo) {

    public ConsertoEspecificoDTO(Conserto conserto){
        this(conserto.getId(), conserto.getDataEntradaOficina(), conserto.getDataSaidaOficina(),
                conserto.getMecanicoResponsavel().getNome(), conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }

}
