package casa.gestionespese.dto.response;

import casa.gestionespese.model.Scontrino;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScontrinoEmessoDtoRespose {

    private long id;
    private String nomeSupermercato;

    private LocalDate dataDiEmissione;

    private List<ProdottoScontrinoDtoResponse> prodotti;

    private double prezzoTot;

}
