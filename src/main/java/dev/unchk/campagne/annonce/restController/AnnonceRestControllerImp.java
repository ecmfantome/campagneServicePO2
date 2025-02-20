package dev.unchk.campagne.annonce.restController;

import dev.unchk.campagne.annonce.dto.AnnonceRequest;
import dev.unchk.campagne.annonce.dto.AnnonceResponse;
import dev.unchk.campagne.annonce.service.AnnonceServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/annonce")
@AllArgsConstructor
public class AnnonceRestControllerImp implements IRestController {

    private final AnnonceServiceImp annonceServiceImp;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAnnonce(@RequestBody AnnonceRequest annonce, BindingResult bindingResult) {
        return annonceServiceImp.saveAnnonce(annonce, bindingResult);
    }

    @Override
    @GetMapping("annee/{anneeId}")
    public List<AnnonceResponse> findAllAnnonceByAnneeId(@PathVariable String anneeId) {
        return annonceServiceImp.findAllAnnonceByAnneeId(anneeId);
    }

    @Override
    @GetMapping("/{annonceId}")
    public AnnonceResponse findAnnonceById(@PathVariable String annonceId) {
        return annonceServiceImp.findAnnonceById(annonceId);
    }

    @Override
    @PutMapping
    public Boolean updateAnnonce(@RequestBody AnnonceRequest annonce, BindingResult bindingResult) {
        return annonceServiceImp.updateAnnonce(annonce, bindingResult);
    }

    @Override
    @DeleteMapping("/{annonceId}")
    public Boolean deleteAnnonce(@PathVariable String annonceId) {
        return annonceServiceImp.deleteAnnonce(annonceId);
    }
}
