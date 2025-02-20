package dev.unchk.campagne.dossier.service;

import dev.unchk.campagne.annonce.Annonce;
import dev.unchk.campagne.dossier.Dossier;
import dev.unchk.campagne.dossier.DossierRepository;
import dev.unchk.campagne.dossier.customeException.DossierNotFoundException;
import dev.unchk.campagne.dossier.dto.DossierRequest;
import dev.unchk.campagne.dossier.mapper.IMapper;
import dev.unchk.campagne.entitySheared.SharedHandlerError;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
@Transactional
@AllArgsConstructor
public class ServiceImpl implements IService {

    private DossierRepository dossierRepository;
    private SharedHandlerError sharedHandlerError;
    private IMapper mapper;

    @Override
    public boolean save(DossierRequest dossierRequest, BindingResult bindingResult) throws RuntimeException {
        sharedHandlerError.handlerValidate(bindingResult);

        Dossier dossier = mapper.toDossier(dossierRequest);
        dossier.setAnnonce(Annonce.builder().id(dossierRequest.getAnnonceId()).build());

        dossierRepository.save(dossier);
        return true;
    }

    @Override
    public boolean update(DossierRequest dossierRequest, BindingResult bindingResult) throws RuntimeException {
        //Validation
        sharedHandlerError.handlerValidate(bindingResult);
        //Verification
        check(dossierRequest.getId());
        //Update
        Dossier dossier = mapper.toDossier(dossierRequest);
        dossier.setAnnonce(Annonce.builder().id(dossierRequest.getAnnonceId()).build());

        dossierRepository.save(dossier);
        return false;
    }

    @Override
    public boolean delete(String id) throws RuntimeException {
        check(id);
        dossierRepository.deleteById(id);
        return true;
    }

    @Override
    public Dossier check(String id) throws DossierNotFoundException {
        return dossierRepository.findById(id).orElseThrow(DossierNotFoundException::new);
    }
}
