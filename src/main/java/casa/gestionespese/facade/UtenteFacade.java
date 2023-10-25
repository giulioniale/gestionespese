package casa.gestionespese.facade;

import casa.gestionespese.dto.request.ProdottoDtoRequest;
import casa.gestionespese.dto.request.RigaScontrinoDtoRequest;
import casa.gestionespese.dto.request.ScontrinoDtoRequest;
import casa.gestionespese.dto.response.ProdottoDtoResponse;
import casa.gestionespese.dto.response.RigaScontrinoDtoResponse;
import casa.gestionespese.dto.response.ScontrinoDtoResponse;
import casa.gestionespese.dto.response.ScontrinoEmessoDtoRespose;
import casa.gestionespese.exception.model.DatiNonTrovatiException;
import casa.gestionespese.mapper.ProdottoMapper;
import casa.gestionespese.mapper.RigaScontrinoMapper;
import casa.gestionespese.mapper.ScontrinoMapper;
import casa.gestionespese.model.Prodotto;
import casa.gestionespese.model.RigaScontrino;
import casa.gestionespese.model.Scontrino;
import casa.gestionespese.service.impl.ProdottoServImpl;
import casa.gestionespese.service.impl.RigaScontrinoImpl;
import casa.gestionespese.service.impl.ScontrinoServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UtenteFacade {
    @Autowired
    ProdottoServImpl prodottoServ;
    @Autowired
    ScontrinoServImpl scontrinoServ;
    @Autowired
    RigaScontrinoImpl rigaServ;
    @Autowired
    ProdottoMapper prodottoMapper;
    @Autowired
    RigaScontrinoMapper rigaMapper;
    @Autowired
    ScontrinoMapper scontrinoMapper;

    public String aggiungiProdotto(ProdottoDtoRequest request){
        prodottoServ.save(prodottoMapper.toProdottoFromDtoRequest(request));
        return "prodotto aggiunto";
    }

    public List<ProdottoDtoResponse> findAllNotDeleted(){
         return prodottoServ.findAllNotDeleted();
    }

    public String deleteProdById(long id) {
        prodottoServ.findById(id);
        prodottoServ.deleteById(id);
        return "Prodotto rimosso con successo";
    }

    public RigaScontrinoDtoResponse addRiga(RigaScontrinoDtoRequest request) {
        if(prodottoServ.existById(request.getIdProdotto()) &&
                scontrinoServ.existById(request.getIdScontrino())){
            if(rigaServ.findByIdProdotto(request.getIdProdotto())!=null){
                RigaScontrino rigaTrovata = rigaServ.findByIdProdotto(request.getIdProdotto());
                rigaTrovata.setQuantita(rigaTrovata.getQuantita()+request.getQuantita());
                rigaTrovata.setPrezzoTot(rigaTrovata.getQuantita()*rigaTrovata.getProdotto().getPrezzo());
                rigaServ.save(rigaTrovata);
                return rigaMapper.toDtoResponseFromRigaScontrino(rigaTrovata);
            }
            Scontrino s = scontrinoServ.aggiungiRiga(rigaMapper.toRigaScontrinoFromDtoRequest(request));
            RigaScontrino riga = rigaMapper.toRigaScontrinoFromDtoRequest(request);
            rigaServ.save(riga);
            return rigaMapper.toDtoResponseFromRigaScontrino(riga);
        }
        throw new DatiNonTrovatiException("Nessun prodotto trovato con ID prodotto: " +request.getIdProdotto());
    }

    public ScontrinoDtoResponse addScontrino(ScontrinoDtoRequest request) {
        Scontrino scontrino = scontrinoMapper.toScontrinoFromDtoRequest(request);
        scontrinoServ.save(scontrino);
        return scontrinoMapper.toDtoResponseFromScontrino(scontrinoServ.findById(scontrino.getId()));
    }

    public ScontrinoEmessoDtoRespose emettiSconntrino(long idScontrino) {
        Scontrino scontrino = scontrinoServ.findById(idScontrino);
        scontrino.setDataDiAcquisto(LocalDate.now());
        double prezzoTot = scontrino.getPrezzoTot();
        if(scontrino.getRighe()!=null && !scontrino.getRighe().isEmpty()){
            for(RigaScontrino r:scontrino.getRighe()){
                prezzoTot= prezzoTot+r.getPrezzoTot();
            }
            scontrino.setPrezzoTot(prezzoTot);
            scontrinoServ.save(scontrino);
            return scontrinoMapper.toDtoEmessoResponseFromScontrino(scontrino);
        }
        return null;
    }
}
