package casa.gestionespese.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scontrino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nomeSupermercato;

    @Column(nullable = false)
    private LocalDate dataDiAcquisto;

    @Column(nullable = false)
    private double prezzoTot;

    @OneToMany(mappedBy = "scontrino")
    private List<RigaScontrino> righe;
}
