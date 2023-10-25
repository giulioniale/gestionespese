package casa.gestionespese.mapper;

import casa.gestionespese.dto.request.ProdottoDtoRequest;
import casa.gestionespese.dto.response.ProdottoDtoResponse;
import casa.gestionespese.dto.response.ProdottoScontrinoDtoResponse;
import casa.gestionespese.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdottoMapper {

    public Prodotto toProdottoFromDtoRequest(ProdottoDtoRequest request){
        Prodotto newProdotto = new Prodotto();
        newProdotto.setNome(request.getNome());
        newProdotto.setDescrizione(request.getDescrizione());
        newProdotto.setPrezzo(request.getPrezzo());
        newProdotto.setNumeroUnita(request.getNumeroUnita());
        newProdotto.setPeso(request.getPeso());
        return newProdotto;
    }

    public ProdottoDtoResponse toDtoResponseFromProdotto(Prodotto request){
        ProdottoDtoResponse newDtoResp = new ProdottoDtoResponse();
        newDtoResp.setId(request.getId());
        newDtoResp.setNome(request.getNome());
        newDtoResp.setDescrizione(request.getDescrizione());
        newDtoResp.setPrezzo(request.getPrezzo());
        return newDtoResp;
    }

    public List<ProdottoDtoResponse> toDtoResponseFromProdottoList(List<Prodotto> prodotti){
        return prodotti.stream().map(this::toDtoResponseFromProdotto).toList();
    }

    public ProdottoScontrinoDtoResponse toProdottoScontrinoDtoResponseFromProdotto(Prodotto response){
        ProdottoScontrinoDtoResponse p =new ProdottoScontrinoDtoResponse();
        p.setNome(response.getNome());
        p.setDescrizione(response.getDescrizione());
        p.setPrezzo(response.getPrezzo());
        return p;
    }

    public List<ProdottoScontrinoDtoResponse> toProdottoScontListDtoResponseFromProdottiList(List<Prodotto> prodotti){
        return prodotti.stream().map(this::toProdottoScontrinoDtoResponseFromProdotto).toList();
    }

}
