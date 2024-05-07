//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.conserto;

import com.example.apiMecanico.especiais.AtualizacaoConsertoDTO;
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
    private Boolean ativo;

    public Conserto(ConsertoDTO consDto){
        this.ativo = true;
        this.dataEntradaOficina = consDto.dataEntradaOficina();
        this.dataSaidaOficina = consDto.dataSaidaOficina();
        this.mecanicoResponsavel = new Mecanico(consDto.mecanicoResponsavel());
        this.veiculo = new Veiculo(consDto.veiculo());
    }


    public void excluir(){
        this.ativo = false;
    }

    public void atualizarInformacoes(AtualizacaoConsertoDTO dados) {
        if(dados.dataSaida() != null){
            this.dataSaidaOficina = dados.dataSaida();
        }
        if(dados.mecanico() != null){
            this.mecanicoResponsavel.atualizarInformacoes(dados.mecanico());
        }
    }
}
