package dev.unchk.campagne.motif.customeException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MotifNotFoundException extends RuntimeException {
    public MotifNotFoundException() {
        super("Ce motif n'existe pas !");
    }
}
