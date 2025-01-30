package dev.unchk.campagne.annee.mapper;

import dev.unchk.campagne.annee.AnneeAcademique;
import dev.unchk.campagne.annee.dto.AnneeRequest;
import dev.unchk.campagne.annee.dto.AnneeResponse;

import java.util.List;

public interface IMapper {

    AnneeAcademique toAnnee(AnneeRequest anneeRequest);

    List<AnneeAcademique> toAnnees(List<AnneeRequest> anneesRequest);

    AnneeResponse toAnneeResponse(AnneeAcademique annee);

    List<AnneeResponse> toAnneesResponse(List<AnneeAcademique> annees);
}
