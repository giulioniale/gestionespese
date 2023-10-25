package casa.gestionespese.mapper;

import casa.gestionespese.dto.request.RigaScontrinoDtoRequest;
import casa.gestionespese.dto.response.RigaScontrinoDtoResponse;
import casa.gestionespese.model.Prodotto;
import casa.gestionespese.model.RigaScontrino;
import casa.gestionespese.service.impl.ProdottoServImpl;
import casa.gestionespese.service.impl.ScontrinoServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RigaScontrinoMapper {
    @Autowired
    ScontrinoServImpl scontrinoServ;
    @Autowired
    ProdottoServImpl prodottoServ;

    //converto una RigaScontirnoRequest -> RigaScontrino
    public RigaScontrino toRigaScontrinoFromDtoRequest(RigaScontrinoDtoRequest request){
        RigaScontrino r = new RigaScontrino();
        Prodotto p = prodottoServ.findById(request.getIdProdotto());
        double prezzoTot;
        r.setScontrino(scontrinoServ.findById(request.getIdScontrino()));
        r.setProdotto(prodottoServ.findById(request.getIdProdotto()));
        r.setQuantita(request.getQuantita());
        prezzoTot=r.getPrezzoTot()+(p.getPrezzo()*r.getQuantita());
        if(request.getSconto() > 0.0){
            r.setSconto(request.getSconto());
            prezzoTot=prezzoTot-r.getSconto();
        }
        r.setPrezzoTot(prezzoTot);
        return r;
    }

    //converto una RigaScontrino -> RigaScontrinoDtoResponse
    public RigaScontrinoDtoResponse toDtoResponseFromRigaScontrino(RigaScontrino riga){
        RigaScontrinoDtoResponse r = new RigaScontrinoDtoResponse();
        r.setIdScontrino(riga.getScontrino().getId());
        r.setIdRiga(riga.getId());
        r.setNomeProdotto(riga.getProdotto().getNome());
        r.setQuantita(riga.getQuantita());
        r.setPrezzoSingolo(riga.getProdotto().getPrezzo());
        r.setPrezzoTot(riga.getPrezzoTot());
        return r;
    }

    //converto una List<RigaScontrino> -> List<RigaScontrinoDtoResponse>
    public List<RigaScontrinoDtoResponse> toDtoResponseListFromRigaScontrinoList(List<RigaScontrino> righe){
        if(righe==null){
            return null;
        }
        return righe.stream().map(this::toDtoResponseFromRigaScontrino).toList();
    }
}
