package casa.gestionespese.service.def;

import casa.gestionespese.model.RigaScontrino;
import casa.gestionespese.model.Scontrino;

import java.time.LocalDate;
import java.util.List;

public interface ScontrinoServiceDef {
    void save(Scontrino scontrino);
    Scontrino findById(long id);
    List<Scontrino> findAll();
    List<Scontrino> findAllByDataDiAcquisto (LocalDate dataDiAcquisto);
    List<Scontrino> findAllByNomeSupermercatoAndDataDiAcquisto(String nomeSupermercato, LocalDate dataDiAcquisto);
    Scontrino aggiungiRiga(RigaScontrino rigaScontrino);

    boolean existById(long idScontrino);
}
