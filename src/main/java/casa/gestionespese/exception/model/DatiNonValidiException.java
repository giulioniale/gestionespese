package casa.gestionespese.exception.model;

import lombok.Getter;

public class DatiNonValidiException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    @Getter
    private Object oggetto;
    public DatiNonValidiException() {
        super();
    }

    public DatiNonValidiException(String message, Object oggetto) {
        super(message);
        this.oggetto = oggetto;
    }

    public DatiNonValidiException(String message) {
        super(message);
    }
}
