//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.mecanico;

import jakarta.validation.constraints.NotBlank;


public record MecanicoDTO(
        @NotBlank
        String nome,
        Integer anosExperiencia) {
}
