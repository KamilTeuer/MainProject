package cz;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Anotace, která zpracovává daný HTTP status.
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
    
}
