package dev.unchk.campagne.dossier.mapper;

import dev.unchk.campagne.dossier.Dossier;
import dev.unchk.campagne.dossier.dto.DossierRequest;
import dev.unchk.campagne.dossier.dto.DossierResponse;

public interface IMapper {

    Dossier toDossier(DossierRequest dossierRequest);

    DossierResponse toDossierResponse(Dossier dossier);

}
