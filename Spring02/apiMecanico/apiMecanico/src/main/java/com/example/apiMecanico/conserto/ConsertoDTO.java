//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.conserto;

import com.example.apiMecanico.mecanico.MecanicoDTO;
import com.example.apiMecanico.veiculo.VeiculoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;



public record ConsertoDTO(
        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataEntradaOficina,
        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataSaidaOficina,
        @NotNull
        @Valid
        MecanicoDTO mecanicoResponsavel,
        @NotNull
        @Valid
        VeiculoDTO veiculo) {
}
