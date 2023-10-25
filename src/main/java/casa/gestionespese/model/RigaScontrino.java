package casa.gestionespese.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RigaScontrino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int quantita;

    private double sconto;

    private double prezzoTot;

    @ManyToOne
    private Prodotto prodotto;

    @ManyToOne()
    private Scontrino scontrino;
}
