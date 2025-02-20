package dev.unchk.campagne.annee.restController;

import dev.unchk.campagne.annee.dto.AnneeRequest;
import dev.unchk.campagne.annee.dto.AnneeResponse;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IRestController {

    public String saveAnnee(AnneeRequest annee, BindingResult bindingResult);

    public List<AnneeResponse> findAllAnnee();

    public AnneeResponse findAnneeById(String anneeId);

    public Boolean updateAnnee(AnneeRequest annee, BindingResult bindingResult);

    public Boolean deleteAnnee(String anneeId);
}
