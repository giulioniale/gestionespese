package casa.gestionespese.service.def;

import casa.gestionespese.dto.response.ProdottoDtoResponse;
import casa.gestionespese.model.Prodotto;
import casa.gestionespese.repository.ProdottoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProdottoServDef {
    void save(Prodotto prodotto);
    Prodotto findById(Long idProdotto);
    List<ProdottoDtoResponse> findAllNotDeleted();
    void deleteById(long id);

    boolean existById(long idProdotto);
}
