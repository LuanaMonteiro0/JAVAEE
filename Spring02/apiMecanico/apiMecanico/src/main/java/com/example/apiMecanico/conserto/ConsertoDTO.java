//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.conserto;

import com.example.apiMecanico.mecanico.MecanicoDTO;
import com.example.apiMecanico.veiculo.VeiculoDTO;

import java.time.LocalDate;

public record ConsertoDTO(String dataEntradaOficina, String dataSaidaOficina, MecanicoDTO mecanicoResponsavel, VeiculoDTO veiculo) {
}
