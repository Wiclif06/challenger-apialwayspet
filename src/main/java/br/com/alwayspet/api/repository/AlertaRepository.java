package br.com.alwayspet.api.repository;
import br.com.alwayspet.api.domain.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    Page<Alerta> findByStatus(StatusAlerta status, Pageable pageable);
}
