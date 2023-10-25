package casa.gestionespese.repository;

import casa.gestionespese.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdottoRepo extends JpaRepository<Prodotto, Long> {
    List<Prodotto> findAllByIsDeletedFalse();
}
