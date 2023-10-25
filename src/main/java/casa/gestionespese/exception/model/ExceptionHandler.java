package casa.gestionespese.exception.model;

import casa.gestionespese.dto.response.MessageDtoResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(DatiNonValidiException.class)
    public ResponseEntity<MessageDtoResponse> handleDatiNonValidi(DatiNonValidiException e){
        MessageDtoResponse m = new MessageDtoResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(), e.getOggetto(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDtoResponse> validationError(MethodArgumentNotValidException e){
        Map<String,String> map = e.getBindingResult()
                .getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
        List<String> errori = new ArrayList<>();
        for (String s : map.keySet()) {
            errori.add(s+": "+map.get(s));
        }
        MessageDtoResponse m = new MessageDtoResponse(errori, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
    }
}
