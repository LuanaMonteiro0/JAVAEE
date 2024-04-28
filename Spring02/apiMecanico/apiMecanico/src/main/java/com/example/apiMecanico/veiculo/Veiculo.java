//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.veiculo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String ano;
    private String cor;

    public Veiculo(VeiculoDTO veDTO){
        this.marca = veDTO.marca();
        this.modelo = veDTO.modelo();
        this.ano = veDTO.ano();
        this.cor = veDTO.cor();
    }
}
