package dev.unchk.campagne.dossier.restController;

import dev.unchk.campagne.dossier.dto.DossierRequest;
import org.springframework.validation.BindingResult;

public interface IRest {
    public boolean save(DossierRequest dossierRequest, BindingResult bindingResult) throws RuntimeException;

    public boolean update(DossierRequest dossierRequest, BindingResult bindingResult) throws RuntimeException;

    public boolean delete(String id) throws RuntimeException;

}
