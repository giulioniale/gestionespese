package casa.gestionespese.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScontrinoDtoResponse {

    private long idScontrino;
    private String nomeSupermercato;
    private LocalDate dataDiAcquisto;
    private double prezzoTot;

}
