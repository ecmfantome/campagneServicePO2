package dev.unchk.campagne.dossier.mapper;

import dev.unchk.campagne.dossier.Dossier;
import dev.unchk.campagne.dossier.dto.DossierRequest;
import dev.unchk.campagne.dossier.dto.DossierResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DossierMapperImp implements IMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Dossier toDossier(DossierRequest dossierRequest) {
        return modelMapper.map(dossierRequest, Dossier.class);
    }

    @Override
    public DossierResponse toDossierResponse(Dossier dossier) {
        return modelMapper.map(dossier, DossierResponse.class);
    }
}
