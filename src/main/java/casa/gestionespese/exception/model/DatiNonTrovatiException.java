package casa.gestionespese.exception.model;

import lombok.Getter;

public class DatiNonTrovatiException extends RuntimeException{

    private static final long serialVersionUID=1L;
    @Getter
    private Object oggetto;

    public DatiNonTrovatiException(String message, Object oggetto){
        super(message);
        this.oggetto=oggetto;
    }

    public DatiNonTrovatiException(String message){
        super(message);
    }
}
