package dev.unchk.campagne.motif.service;

import dev.unchk.campagne.motif.Motif;
import dev.unchk.campagne.motif.MotifRepository;
import dev.unchk.campagne.motif.customeException.MotifNotFoundException;
import dev.unchk.campagne.motif.dto.MotifRequest;
import dev.unchk.campagne.motif.dto.MotifResponse;
import dev.unchk.campagne.entitySheared.SharedHandlerError;
import dev.unchk.campagne.motif.mapper.MotifMapperImp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


@Service
@AllArgsConstructor
public class MotifServiceImp implements IService {

    private final MotifRepository motifRepository;
    private final MotifMapperImp motifMapperImp;
    private final SharedHandlerError sharedHandlerError;

    @Override
    public String saveMotif(MotifRequest motifRequest, BindingResult bindingResult) throws RuntimeException {
        sharedHandlerError.handlerValidate(bindingResult);
        return motifRepository.save(motifMapperImp.toMotif(motifRequest)).getId();
    }

    @Override
    public MotifResponse findMotifById(String motifId) throws RuntimeException {
        Motif motif = checkMotif(motifId);
        return  motifMapperImp.toMotifResponse(motif);
    }

    @Override
    public Boolean updateMotif(MotifRequest motifRequest, BindingResult bindingResult) throws RuntimeException {
        sharedHandlerError.handlerValidate(bindingResult); 
        checkMotif(motifRequest.getId());
        motifRepository.save(motifMapperImp.toMotif(motifRequest));
        return true;
    }

    @Override
    public Boolean deleteMotif(String motifId) throws RuntimeException {
        checkMotif(motifId);
        motifRepository.deleteById(motifId);
        return true;
    }

    @Override
    public Motif checkMotif(String motifId) throws MotifNotFoundException {
        if (motifId == null) throw new MotifNotFoundException();
        return motifRepository.findById(motifId).orElseThrow(MotifNotFoundException::new);
    }
}
