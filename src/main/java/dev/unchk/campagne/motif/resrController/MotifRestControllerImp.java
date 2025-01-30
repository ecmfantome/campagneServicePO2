package dev.unchk.campagne.motif.resrController;

import dev.unchk.campagne.motif.dto.MotifRequest;
import dev.unchk.campagne.motif.dto.MotifResponse;
import dev.unchk.campagne.motif.service.MotifServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/motif")
@AllArgsConstructor
public class MotifRestControllerImp implements IRestController {

    private final MotifServiceImp motifServiceImp;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveMotif(MotifRequest motif, BindingResult bindingResult) {
        return motifServiceImp.saveMotif(motif, bindingResult);
    }

    @Override
    @GetMapping("/{motifId}")
    public MotifResponse findMotifById(@PathVariable String motifId) {
        return motifServiceImp.findMotifById(motifId);
    }

    @Override
    @PutMapping
    public Boolean updateMotif(MotifRequest motif, BindingResult bindingResult) {
        return motifServiceImp.updateMotif(motif, bindingResult);
    }

    @Override
    @DeleteMapping("/{motifId}")
    public Boolean deleteMotif(@PathVariable String motifId) {
        return  motifServiceImp.deleteMotif(motifId);
    }
}
