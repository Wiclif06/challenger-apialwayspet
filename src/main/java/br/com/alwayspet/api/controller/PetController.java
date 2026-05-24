package br.com.alwayspet.api.controller;

import br.com.alwayspet.api.domain.Especie;
import br.com.alwayspet.api.dto.PetRequest;
import br.com.alwayspet.api.dto.PetResponse;
import br.com.alwayspet.api.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/pets")
@Tag(name = "Pets", description = "Cadastro, consulta e acompanhamento dos pets")
public class PetController {

    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar pets", description = "Lista pets com paginação, ordenação e filtros opcionais por nome e espécie.")
    public ResponseEntity<Page<PetResponse>> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Especie especie,
            Pageable pageable) {

        return ResponseEntity.ok(service.listar(nome, especie, pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pet por ID", description = "Retorna os dados de um pet cadastrado.")
    public ResponseEntity<PetResponse> buscar(
            @Parameter(description = "Identificador do pet", example = "1", required = true)
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar pet", description = "Cria um novo cadastro de pet vinculado a um responsável existente.")
    public ResponseEntity<PetResponse> criar(@RequestBody @Valid PetRequest request) {
        PetResponse response = service.criar(request);
        return ResponseEntity.created(URI.create("/api/pets/" + response.id())).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar pet", description = "Atualiza os dados principais de um pet já cadastrado.")
    public ResponseEntity<PetResponse> atualizar(
            @Parameter(description = "Identificador do pet", example = "1", required = true)
            @PathVariable("id") Long id,
            @RequestBody @Valid PetRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover pet", description = "Remove um pet cadastrado.")
    public ResponseEntity<Void> remover(
            @Parameter(description = "Identificador do pet", example = "1", required = true)
            @PathVariable("id") Long id) {

        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
