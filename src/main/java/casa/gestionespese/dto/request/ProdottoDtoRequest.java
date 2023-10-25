package casa.gestionespese.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdottoDtoRequest {

    @NotBlank(message = "devi inserire un nome al prodotto")
    public String nome;

    public String descrizione;
    @NotNull(message = "devi inserire un prezzo")
    @Positive(message = "il prezzo deve essere un numero positivo")
    public double prezzo;
    public int numeroUnita;
    public double peso;

}
