package dev.unchk.campagne.annee.service;

import dev.unchk.campagne.annee.AnneeAcademique;
import dev.unchk.campagne.annee.dto.AnneeRequest;
import dev.unchk.campagne.annee.dto.AnneeResponse;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IService {
    String saveAnnee(AnneeRequest anneeRequest, BindingResult bindingResult);

    List<AnneeResponse> findAllAnnee();

    AnneeAcademique checkAnnee(String anneeId);

    AnneeResponse findAnneeById(String anneeId);

    Boolean updateAnnee(AnneeRequest anneeRequest, BindingResult bindingResult);

    Boolean deleteAnnee(String anneeId);
}
