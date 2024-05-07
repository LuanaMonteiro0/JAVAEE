package com.example.apiMecanico.especiais;

import com.example.apiMecanico.mecanico.MecanicoDTO;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoConsertoDTO(
        @NotNull
        Long id,
        String dataSaida,
        MecanicoDTO mecanico) {
}
