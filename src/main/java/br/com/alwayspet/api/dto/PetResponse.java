package br.com.alwayspet.api.dto;

import br.com.alwayspet.api.domain.Especie;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Dados retornados na consulta de pets")
public record PetResponse(

        @Schema(example = "1")
        Long id,

        @Schema(example = "Thor")
        String nome,

        @Schema(example = "CANINO")
        Especie especie,

        @Schema(example = "Golden Retriever")
        String raca,

        @Schema(example = "2022-05-10")
        LocalDate dataNascimento,

        @Schema(example = "Mariana Alves")
        String responsavel
) {
}
