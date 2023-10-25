package casa.gestionespese.mapper;

import casa.gestionespese.dto.request.ScontrinoDtoRequest;
import casa.gestionespese.dto.response.ProdottoScontrinoDtoResponse;
import casa.gestionespese.dto.response.ScontrinoDtoResponse;
import casa.gestionespese.dto.response.ScontrinoEmessoDtoRespose;
import casa.gestionespese.model.RigaScontrino;
import casa.gestionespese.model.Scontrino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScontrinoMapper {
    @Autowired
    ProdottoMapper prodottoMapper;

    public Scontrino toScontrinoFromDtoRequest(ScontrinoDtoRequest request){
        Scontrino s = new Scontrino();
        List<RigaScontrino> righe = new ArrayList<>();
        s.setNomeSupermercato(request.getNomeSupermercato());
        s.setDataDiAcquisto(request.getDataDiCreazione());
        s.setPrezzoTot(0.0);
        s.setRighe(righe);
        return s;
    }

    public ScontrinoDtoResponse toDtoResponseFromScontrino(Scontrino response){
        ScontrinoDtoResponse s = new ScontrinoDtoResponse();
        s.setIdScontrino(s.getIdScontrino());
        s.setNomeSupermercato(response.getNomeSupermercato());
        s.setPrezzoTot(response.getPrezzoTot());
        s.setDataDiAcquisto(response.getDataDiAcquisto());
        return s;
    }

    public List<ScontrinoDtoResponse> toDtoResponseListFromScontrinoList(List<Scontrino> responseList){
        if(responseList==null){
            return null;
        }
        return responseList.stream().map(this::toDtoResponseFromScontrino).toList();
    }

    public ScontrinoEmessoDtoRespose toDtoEmessoResponseFromScontrino(Scontrino response){
        ScontrinoEmessoDtoRespose scontrinoEme= new ScontrinoEmessoDtoRespose();
        scontrinoEme.setId(response.getId());
        scontrinoEme.setNomeSupermercato(response.getNomeSupermercato());
        scontrinoEme.setDataDiEmissione(response.getDataDiAcquisto());
        List<ProdottoScontrinoDtoResponse>prodotti = response.getRighe()
                .stream()
                .map(r-> new ProdottoScontrinoDtoResponse
                        (r.getProdotto().getNome(), r.getProdotto().getDescrizione(), r.getProdotto().getPrezzo()))
                .toList();
        scontrinoEme.setProdotti(prodotti);
        scontrinoEme.setPrezzoTot(response.getPrezzoTot());
        return scontrinoEme;
    }
}
