package casa.gestionespese.repository;

import casa.gestionespese.model.RigaScontrino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RigaScontrinoRepo extends JpaRepository<RigaScontrino, Long> {
    RigaScontrino findByProdotto_Id(long idProdotto);
    List<RigaScontrino> findAllByScontrino_Id(long idScontrino);

}
