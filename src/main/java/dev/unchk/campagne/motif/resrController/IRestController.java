package dev.unchk.campagne.motif.resrController;

import dev.unchk.campagne.motif.dto.MotifRequest;
import dev.unchk.campagne.motif.dto.MotifResponse;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IRestController {

    public String saveMotif(MotifRequest motif, BindingResult bindingResult);

    public MotifResponse findMotifById(String motifId);

    public Boolean updateMotif(MotifRequest motif, BindingResult bindingResult);

    public Boolean deleteMotif(String motifId);
}
