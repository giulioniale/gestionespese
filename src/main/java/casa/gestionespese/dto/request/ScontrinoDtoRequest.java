package casa.gestionespese.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScontrinoDtoRequest {

    @NotBlank(message= "Devi inserire il nome del supermercato")
    private String nomeSupermercato;

    @NotBlank(message= "Devi inserire una data")
    private LocalDate dataDiCreazione;
}
