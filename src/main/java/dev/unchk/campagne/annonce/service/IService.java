package dev.unchk.campagne.annonce.service;

import dev.unchk.campagne.annonce.Annonce;
import dev.unchk.campagne.annonce.dto.AnnonceRequest;
import dev.unchk.campagne.annonce.dto.AnnonceResponse;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IService {
    String saveAnnonce(AnnonceRequest annonceRequest, BindingResult bindingResult);

    List<AnnonceResponse> findAllAnnonceByAnneeId(String anneeId);

    Annonce checkAnnonce(String annonceId);

    AnnonceResponse findAnnonceById(String annonceId);

    Boolean updateAnnonce(AnnonceRequest annonceRequest, BindingResult bindingResult);

    Boolean deleteAnnonce(String annonceId);
}
