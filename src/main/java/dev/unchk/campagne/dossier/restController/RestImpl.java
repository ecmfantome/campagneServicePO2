package dev.unchk.campagne.dossier.restController;

import dev.unchk.campagne.dossier.dto.DossierRequest;
import dev.unchk.campagne.dossier.service.IService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dossier")
@AllArgsConstructor
public class RestImpl implements IRest {

    private IService service;

    @PostMapping
    @Override
    public boolean save(@RequestBody @Valid DossierRequest dossierRequest, BindingResult bindingResult) throws RuntimeException {
        return service.save(dossierRequest, bindingResult);
    }

    @PutMapping
    @Override
    public boolean update(@RequestBody @Valid DossierRequest dossierRequest, BindingResult bindingResult) throws RuntimeException {
        return service.update(dossierRequest, bindingResult);
    }

    @DeleteMapping("/{id}")
    @Override
    public boolean delete(@PathVariable String id) throws RuntimeException {
        return service.delete(id);
    }

}
