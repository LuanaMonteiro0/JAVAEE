//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.conserto;

import com.example.apiMecanico.mecanico.Mecanico;
import com.example.apiMecanico.veiculo.Veiculo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "consertos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntradaOficina;
    private String dataSaidaOficina;
    @Embedded
    private Mecanico mecanicoResponsavel;
    @Embedded
    private Veiculo veiculo;

    public Conserto(ConsertoDTO consDto){
        this.dataEntradaOficina = consDto.dataEntradaOficina();
        this.dataSaidaOficina = consDto.dataSaidaOficina();
        this.mecanicoResponsavel = new Mecanico(consDto.mecanicoResponsavel());
        this.veiculo = new Veiculo(consDto.veiculo());
    }
}
