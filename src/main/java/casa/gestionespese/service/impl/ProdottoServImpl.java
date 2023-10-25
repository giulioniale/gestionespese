package casa.gestionespese.service.impl;

import casa.gestionespese.dto.response.ProdottoDtoResponse;
import casa.gestionespese.exception.model.DatiNonTrovatiException;
import casa.gestionespese.mapper.ProdottoMapper;
import casa.gestionespese.model.Prodotto;
import casa.gestionespese.repository.ProdottoRepo;
import casa.gestionespese.service.def.ProdottoServDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoServImpl implements ProdottoServDef {

    @Autowired
    ProdottoRepo prodottoRepo;
    @Autowired
    ProdottoMapper prodottoMapper;
    @Override
    public void save(Prodotto prodotto) {
    prodottoRepo.save(prodotto);
    }

    @Override
    public Prodotto findById(Long idProdotto) {
        return prodottoRepo.findById(idProdotto)
                .orElseThrow(()->new DatiNonTrovatiException("Nessun prodotto trovato con ID: " +idProdotto));
    }

    @Override
    public List<ProdottoDtoResponse> findAllNotDeleted() {
        return prodottoMapper.toDtoResponseFromProdottoList(prodottoRepo.findAllByIsDeletedFalse());
    }

    @Override
    public void deleteById(long id) {
        Prodotto p = prodottoRepo.findById(id)
                .orElseThrow(()->new DatiNonTrovatiException("Nessun prodotto trovato con ID: " +id));
        p.isDeleted(true);
        prodottoRepo.save(p);
    }

    @Override
    public boolean existById(long idProdotto) {
        if(prodottoRepo.existsById(idProdotto)){
            return true;
        }
        return false;
    }
}
