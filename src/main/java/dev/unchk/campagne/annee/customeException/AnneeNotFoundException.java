package dev.unchk.campagne.annee.customeException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnneeNotFoundException extends RuntimeException {
    public AnneeNotFoundException() {
        super("Cette année n'existe pas !");
    }
}
