package casa.gestionespese.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RigaScontrinoDtoResponse {
    private long idScontrino;
    private long idRiga;
    private String nomeProdotto;
    private int quantita;
    private double prezzoSingolo;
    private double prezzoTot;
}
