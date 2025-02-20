package dev.unchk.campagne.dossier.customeException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DossierNotFoundException extends RuntimeException {
    public DossierNotFoundException() {
        super("Ce dossier n'existe pas !");
    }
}
