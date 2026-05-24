package br.com.alwayspet.api.service;

import br.com.alwayspet.api.domain.Especie;
import br.com.alwayspet.api.domain.Pet;
import br.com.alwayspet.api.domain.Responsavel;
import br.com.alwayspet.api.dto.PetRequest;
import br.com.alwayspet.api.dto.PetResponse;
import br.com.alwayspet.api.exception.RegistroNaoEncontradoException;
import br.com.alwayspet.api.repository.PetRepository;
import br.com.alwayspet.api.repository.ResponsavelRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final ResponsavelRepository responsavelRepository;

    public PetService(PetRepository petRepository, ResponsavelRepository responsavelRepository) {
        this.petRepository = petRepository;
        this.responsavelRepository = responsavelRepository;
    }

    @Cacheable("pets")
    public Page<PetResponse> listar(String nome, Especie especie, Pageable pageable) {
        Page<Pet> page;

        if (nome != null && !nome.isBlank() && especie != null) {
            page = petRepository.findByNomeContainingIgnoreCaseAndEspecie(nome, especie, pageable);
        } else if (nome != null && !nome.isBlank()) {
            page = petRepository.findByNomeContainingIgnoreCase(nome, pageable);
        } else {
            page = petRepository.findAll(pageable);
        }

        return page.map(this::toResponse);
    }

    public PetResponse buscar(Long id) {
        return toResponse(getPet(id));
    }

    @CacheEvict(value = "pets", allEntries = true)
    public PetResponse criar(PetRequest request) {
        Responsavel responsavel = buscarResponsavel(request.responsavelId());

        Pet pet = new Pet();
        preencherDados(request, pet);
        pet.setResponsavel(responsavel);

        return toResponse(petRepository.save(pet));
    }

    @CacheEvict(value = "pets", allEntries = true)
    public PetResponse atualizar(Long id, PetRequest request) {
        Pet pet = getPet(id);
        Responsavel responsavel = buscarResponsavel(request.responsavelId());

        preencherDados(request, pet);
        pet.setResponsavel(responsavel);

        return toResponse(petRepository.save(pet));
    }

    @CacheEvict(value = "pets", allEntries = true)
    public void remover(Long id) {
        petRepository.delete(getPet(id));
    }

    private Pet getPet(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Pet não encontrado"));
    }

    private Responsavel buscarResponsavel(Long id) {
        return responsavelRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Responsável não encontrado"));
    }

    private void preencherDados(PetRequest request, Pet pet) {
        pet.setNome(request.nome());
        pet.setEspecie(request.especie());
        pet.setRaca(request.raca());
        pet.setDataNascimento(request.dataNascimento());
    }

    private PetResponse toResponse(Pet pet) {
        return new PetResponse(
                pet.getId(),
                pet.getNome(),
                pet.getEspecie(),
                pet.getRaca(),
                pet.getDataNascimento(),
                pet.getResponsavel().getNome()
        );
    }
}
