package dev.unchk.campagne.motif.mapper;

import dev.unchk.campagne.annonce.Annonce;
import dev.unchk.campagne.motif.Motif;
import dev.unchk.campagne.motif.dto.MotifRequest;
import dev.unchk.campagne.motif.dto.MotifResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class MotifMapperImp  implements IMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Motif toMotif(MotifRequest motifRequest) {
       Motif motif =  modelMapper.map(motifRequest, Motif.class);
        return   mapRelationMotif(motif, motifRequest);
    }

 
    @Override
    public MotifResponse toMotifResponse(Motif motif) {
        return modelMapper.map(motif, MotifResponse.class);
    }

    @Override
    public Motif mapRelationMotif(Motif motif, MotifRequest motifRequest) {
     motif.setAnnonce(Annonce.builder().id(motifRequest.getAnnonceId()).build());
        return motif;
    }


}
