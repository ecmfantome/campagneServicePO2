package dev.unchk.campagne.annee.restController;

import dev.unchk.campagne.annee.dto.AnneeRequest;
import dev.unchk.campagne.annee.dto.AnneeResponse;
import dev.unchk.campagne.annee.service.AnneeServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/annee")
@AllArgsConstructor
public class AnneeRestControllerImp implements IRestController {

    private final AnneeServiceImp anneeServiceImp;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAnnee(@RequestBody AnneeRequest annee, BindingResult bindingResult) {
        return anneeServiceImp.saveAnnee(annee, bindingResult);

    }

    @Override
    @GetMapping
    public List<AnneeResponse> findAllAnnee() {
        return anneeServiceImp.findAllAnnee();
    }

    @Override
    @GetMapping("/{anneeId}")
    public AnneeResponse findAnneeById(@PathVariable String anneeId) {
        return anneeServiceImp.findAnneeById(anneeId);
    }

    @Override
    @PutMapping
    public Boolean updateAnnee(@RequestBody AnneeRequest annee, BindingResult bindingResult) {
        return anneeServiceImp.updateAnnee(annee, bindingResult);
    }

    @Override
    @DeleteMapping("/{anneeId}")
    public Boolean deleteAnnee(@PathVariable String anneeId) {
        return anneeServiceImp.deleteAnnee(anneeId);
    }
}
