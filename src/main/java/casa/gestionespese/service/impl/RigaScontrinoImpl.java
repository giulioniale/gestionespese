package casa.gestionespese.service.impl;

import casa.gestionespese.dto.response.RigaScontrinoDtoResponse;
import casa.gestionespese.exception.model.DatiNonTrovatiException;
import casa.gestionespese.model.RigaScontrino;
import casa.gestionespese.repository.RigaScontrinoRepo;
import casa.gestionespese.service.def.RigaScontrinoDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RigaScontrinoImpl implements RigaScontrinoDef {

    @Autowired
    RigaScontrinoRepo rigaRepo;


    @Override
    public RigaScontrino save(RigaScontrino riga) {
        return rigaRepo.save(riga);
    }

    @Override
    public RigaScontrino findById(long id) {
        return rigaRepo.findById(id)
                .orElseThrow(()->new DatiNonTrovatiException("Nessuna riga trovata con ID: " +id));
    }

    @Override
    public RigaScontrino findByIdProdotto(long idProdotto) {
        return rigaRepo.findByProdotto_Id(idProdotto);
    }

    @Override
    public List<RigaScontrino> findAllByIdScontrino(long idScontrino) {
        return rigaRepo.findAllByScontrino_Id(idScontrino);
    }
}
