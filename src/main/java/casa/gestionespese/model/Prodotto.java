package casa.gestionespese.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descrizione;

    @Column(nullable = false)
    private double prezzo;

    private boolean isDeleted=false;

    private int numeroUnita;

    @OneToMany(mappedBy = "prodotto")
    private List<RigaScontrino> righe;

    private double peso;


    public boolean isDeleted(boolean b) {
        this.isDeleted=b;
        return isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return id == prodotto.id && Double.compare(prezzo, prodotto.prezzo) == 0 && isDeleted == prodotto.isDeleted && numeroUnita == prodotto.numeroUnita && Double.compare(peso, prodotto.peso) == 0 && Objects.equals(nome, prodotto.nome) && Objects.equals(descrizione, prodotto.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descrizione, prezzo, isDeleted, numeroUnita, peso);
    }
}
