package br.com.alwayspet.api.dto;

import br.com.alwayspet.api.domain.Especie;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "Dados necessários para cadastrar ou atualizar um pet")
public record PetRequest(

        @Schema(
                description = "Nome do pet",
                example = "Thor"
        )
        @NotBlank(message = "O nome do pet é obrigatório")
        @Size(
                min = 2,
                max = 100,
                message = "O nome do pet deve possuir entre 2 e 100 caracteres"
        )
        String nome,

        @Schema(
                description = "Espécie do pet",
                example = "CANINO"
        )
        @NotNull(message = "A espécie do pet é obrigatória")
        Especie especie,

        @Schema(
                description = "Raça do pet",
                example = "Golden Retriever"
        )
        @Size(
                max = 100,
                message = "A raça do pet deve possuir no máximo 100 caracteres"
        )
        String raca,

        @Schema(
                description = "Data de nascimento aproximada do pet",
                example = "2022-05-10"
        )
        @PastOrPresent(
                message = "A data de nascimento não pode ser futura"
        )
        LocalDate dataNascimento,

        @Schema(
                description = "ID do responsável cadastrado",
                example = "1"
        )
        @NotNull(message = "O responsável do pet é obrigatório")
        Long responsavelId

) {
}