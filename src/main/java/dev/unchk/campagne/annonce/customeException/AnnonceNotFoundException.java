package dev.unchk.campagne.annonce.customeException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnnonceNotFoundException extends RuntimeException {
    public AnnonceNotFoundException() {
        super("Cette annonce n'existe pas !");
    }
}
