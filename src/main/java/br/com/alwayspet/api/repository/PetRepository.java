package br.com.alwayspet.api.repository;
import br.com.alwayspet.api.domain.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PetRepository extends JpaRepository<Pet, Long> {
    Page<Pet> findByNomeContainingIgnoreCaseAndEspecie(String nome, Especie especie, Pageable pageable);
    Page<Pet> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
