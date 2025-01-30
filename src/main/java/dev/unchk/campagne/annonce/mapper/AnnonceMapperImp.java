package dev.unchk.campagne.annonce.mapper;

import dev.unchk.campagne.annee.AnneeAcademique;
import dev.unchk.campagne.annonce.Annonce;
import dev.unchk.campagne.annonce.dto.AnnonceRequest;
import dev.unchk.campagne.annonce.dto.AnnonceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceMapperImp  implements IMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Annonce toAnnonce(AnnonceRequest annonceRequest) {
        Annonce annonce = modelMapper.map(annonceRequest, Annonce.class);
        return  mapRelationAnnonce(annonce, annonceRequest );
    }

    @Override
    public AnnonceResponse toAnnonceResponse(Annonce annonce) {
        return modelMapper.map(annonce, AnnonceResponse.class);
    }

    @Override
    public List<AnnonceResponse> toAnnoncesResponse(List<Annonce> annonces) {
        return annonces.stream().map(clientRequest -> modelMapper.map(clientRequest, AnnonceResponse.class)).toList();
    }

    @Override
    public Annonce mapRelationAnnonce( Annonce annonce,AnnonceRequest annonceRequest) {
        annonce.setAnnee(AnneeAcademique.builder().id(annonceRequest.getAcademiqueId()).build());
        return annonce;
    }
}
