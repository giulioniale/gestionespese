package casa.gestionespese.service.def;

import casa.gestionespese.model.RigaScontrino;

import java.util.List;

public interface RigaScontrinoDef {
    RigaScontrino save(RigaScontrino riga);
    RigaScontrino findById(long id);
    RigaScontrino findByIdProdotto(long idProdotto);
    List<RigaScontrino> findAllByIdScontrino(long idScontrino);
}
