package dev.unchk.campagne.annonce.mapper;


import dev.unchk.campagne.annonce.Annonce;
import dev.unchk.campagne.annonce.dto.AnnonceRequest;
import dev.unchk.campagne.annonce.dto.AnnonceResponse;

import java.util.List;

public interface IMapper {

    Annonce toAnnonce(AnnonceRequest annonceRequest);

    AnnonceResponse toAnnonceResponse(Annonce annonce);

    List<AnnonceResponse> toAnnoncesResponse(List<Annonce> annonces);

    Annonce mapRelationAnnonce( Annonce annonce,AnnonceRequest annonceRequest);

}
