package dev.unchk.campagne.motif.mapper;

import dev.unchk.campagne.annonce.Annonce;
import dev.unchk.campagne.annonce.dto.AnnonceRequest;
import dev.unchk.campagne.motif.Motif;
import dev.unchk.campagne.motif.dto.MotifRequest;
import dev.unchk.campagne.motif.dto.MotifResponse;

public interface IMapper {

    Motif toMotif(MotifRequest motifRequest);

    MotifResponse toMotifResponse(Motif motif);
    Motif mapRelationMotif(Motif motif, MotifRequest motifRequest);

}
