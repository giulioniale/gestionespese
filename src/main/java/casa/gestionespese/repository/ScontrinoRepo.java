package casa.gestionespese.repository;

import casa.gestionespese.model.Scontrino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScontrinoRepo extends JpaRepository<Scontrino,Long> {
    List<Scontrino> findAllByDataDiAcquisto(LocalDate dataDiAcquisto);
    List<Scontrino> findAllByNomeSupermercato(String nomeSupermercato);
    List<Scontrino> findAllByNomeSupermercatoAndDataDiAcquisto(String nomeSupermercato, LocalDate dataDiAcquisto);
}
