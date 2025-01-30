package dev.unchk.campagne.annee.mapper;

import dev.unchk.campagne.annee.AnneeAcademique;
import dev.unchk.campagne.annee.dto.AnneeRequest;
import dev.unchk.campagne.annee.dto.AnneeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnneeMapperImp  implements IMapper{
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public AnneeAcademique toAnnee(AnneeRequest anneeRequest) {
        return modelMapper.map(anneeRequest, AnneeAcademique.class);
    }

    @Override
    public List<AnneeAcademique> toAnnees(List<AnneeRequest> anneesRequest) {
        return anneesRequest.stream().map(clientRequest -> modelMapper.map(clientRequest, AnneeAcademique.class)).toList();
    }

    @Override
    public AnneeResponse toAnneeResponse(AnneeAcademique annee) {
        return modelMapper.map(annee, AnneeResponse.class);
    }

    @Override
    public List<AnneeResponse> toAnneesResponse(List<AnneeAcademique> annees) {
        return annees.stream().map(clientRequest -> modelMapper.map(clientRequest, AnneeResponse.class)).toList();
    }
}
