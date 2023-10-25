package casa.gestionespese.service.impl;

import casa.gestionespese.exception.model.DatiNonTrovatiException;
import casa.gestionespese.model.RigaScontrino;
import casa.gestionespese.model.Scontrino;
import casa.gestionespese.repository.RigaScontrinoRepo;
import casa.gestionespese.repository.ScontrinoRepo;
import casa.gestionespese.service.def.ScontrinoServiceDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScontrinoServImpl implements ScontrinoServiceDef {

    @Autowired
    ScontrinoRepo scontrinoRepo;
    @Override
    public void save(Scontrino scontrino) {
        scontrinoRepo.save(scontrino);
    }
    @Override
    public Scontrino findById(long id) {
        return scontrinoRepo.findById(id).orElseThrow(()->new DatiNonTrovatiException("Nessuno scontrino trovato con ID: " +id));
    }

    @Override
    public List<Scontrino> findAll() {
        return scontrinoRepo.findAll();
    }

    @Override
    public List<Scontrino> findAllByDataDiAcquisto(LocalDate dataDiAcquisto) {
        return scontrinoRepo.findAllByDataDiAcquisto(dataDiAcquisto);
    }

    @Override
    public List<Scontrino> findAllByNomeSupermercatoAndDataDiAcquisto(String nomeSupermercato, LocalDate dataDiAcquisto) {
        return scontrinoRepo.findAllByNomeSupermercatoAndDataDiAcquisto(nomeSupermercato,dataDiAcquisto);
    }

    @Override
    public Scontrino aggiungiRiga(RigaScontrino rigaScontrino) {
        Scontrino scontrino = rigaScontrino.getScontrino();
        List<RigaScontrino> righe = new ArrayList<>();
        if(scontrino.getRighe()==null){
            righe.add(rigaScontrino);
            scontrino.setRighe(righe);
            return scontrino;
        }
        righe= scontrino.getRighe();
        righe.add(rigaScontrino);
        scontrino.setRighe(righe);
        return scontrino;
    }

    @Override
    public boolean existById(long idScontrino) {
        if(scontrinoRepo.existsById(idScontrino)){
            return true;
        }
        return false;
    }
}
