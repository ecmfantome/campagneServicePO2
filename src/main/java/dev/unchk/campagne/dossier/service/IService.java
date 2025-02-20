package dev.unchk.campagne.dossier.service;

import dev.unchk.campagne.dossier.Dossier;
import dev.unchk.campagne.dossier.customeException.DossierNotFoundException;
import dev.unchk.campagne.dossier.dto.DossierRequest;
import org.springframework.validation.BindingResult;

public interface IService {
    public boolean save(DossierRequest dossierRequest, BindingResult bindingResult) throws RuntimeException;

    public boolean update(DossierRequest dossierRequest, BindingResult bindingResult) throws RuntimeException;

    public boolean delete(String id) throws RuntimeException;

    public Dossier check(String id) throws DossierNotFoundException;

//    public ResponseEntity<DossierResponse> findByUserId(String userId) throws RuntimeException;
}
