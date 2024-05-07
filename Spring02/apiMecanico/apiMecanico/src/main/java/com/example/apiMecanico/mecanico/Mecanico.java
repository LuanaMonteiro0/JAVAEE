//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Mecanico {
    private String nome;
    private Integer anosExperiencia;

    public Mecanico (MecanicoDTO mecDTO){
        this.nome = mecDTO.nome();
        this.anosExperiencia = mecDTO.anosExperiencia();
    }

    public void atualizarInformacoes(MecanicoDTO mecanico) {
        if(mecanico.nome() != null){
            this.nome = mecanico.nome();
        }
        if(mecanico.anosExperiencia() != null){
            this.anosExperiencia = mecanico.anosExperiencia();
        }
    }
}
