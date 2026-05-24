package br.com.alwayspet.api.dto;

import br.com.alwayspet.api.domain.Especie;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Schema(description = "Dados necessários para cadastrar ou atualizar um pet")
public record PetRequest(

        @Schema(description = "Nome do pet", example = "Thor")
        @NotBlank(message = "O nome do pet é obrigatório")
        String nome,

        @Schema(description = "Espécie do pet", example = "CANINO")
        @NotNull(message = "A espécie do pet é obrigatória")
        Especie especie,

        @Schema(description = "Raça do pet", example = "Golden Retriever")
        String raca,

        @Schema(description = "Data de nascimento aproximada do pet", example = "2022-05-10")
        LocalDate dataNascimento,

        @Schema(description = "ID do responsável cadastrado", example = "1")
        @NotNull(message = "O responsável do pet é obrigatório")
        Long responsavelId
) {
}
