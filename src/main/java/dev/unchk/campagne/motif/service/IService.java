package dev.unchk.campagne.motif.service;

import dev.unchk.campagne.motif.Motif;
import dev.unchk.campagne.motif.dto.MotifRequest;
import dev.unchk.campagne.motif.dto.MotifResponse;
import org.springframework.validation.BindingResult;


public interface IService {
    String saveMotif(MotifRequest motifRequest, BindingResult bindingResult);

    Motif checkMotif(String motifId);

    MotifResponse findMotifById(String motifId);

    Boolean updateMotif(MotifRequest motifRequest, BindingResult bindingResult);

    Boolean deleteMotif(String motifId);
}
