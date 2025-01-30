package dev.unchk.campagne.annonce.restController;

import dev.unchk.campagne.annonce.dto.AnnonceRequest;
import dev.unchk.campagne.annonce.dto.AnnonceResponse;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IRestController {

    public String saveAnnonce(AnnonceRequest annonce, BindingResult bindingResult);
    public List<AnnonceResponse> findAllAnnonceByAnneeId(String anneeId);

    public AnnonceResponse findAnnonceById(String annonceId);

    public Boolean updateAnnonce(AnnonceRequest annonce, BindingResult bindingResult);

    public Boolean deleteAnnonce(String annonceId);
}
