package casa.gestionespese.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdottoScontrinoDtoResponse {
    public String nome;
    public String descrizione;
    public double prezzo;
}
