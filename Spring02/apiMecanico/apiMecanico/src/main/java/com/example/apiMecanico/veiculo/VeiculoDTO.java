//LUANA MONTEIRO e LUAN MARQUETI

package com.example.apiMecanico.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotBlank
        @Pattern(regexp = "\\d{4}")
        String ano,

        String cor
) {
}
