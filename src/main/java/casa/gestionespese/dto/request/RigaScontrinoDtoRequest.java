package casa.gestionespese.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RigaScontrinoDtoRequest {

    @NotBlank(message= "Devi inserire un ID Scontrino")
    @Min(value =1, message= "Devi inserire un ID maggiore di 0")
    private long idScontrino;

    @NotBlank(message= "Devi inserire un ID Prodotto")
    @Min(value =1, message= "Devi inserire un ID maggiore di 0")
    private long idProdotto;

    @NotBlank(message= "Devi inserire una quantità")
    @Positive(message= "Devi inserire una quantità positiva")
    private int quantita;

    private double sconto;
}
