package dev.unchk.campagne.annee.service;

import dev.unchk.campagne.annee.AnneeAcademique;
import dev.unchk.campagne.annee.AnneeRepository;
import dev.unchk.campagne.annee.customeException.AnneeNotFoundException;
import dev.unchk.campagne.annee.dto.AnneeRequest;
import dev.unchk.campagne.annee.dto.AnneeResponse;
import dev.unchk.campagne.annee.mapper.AnneeMapperImp;
import dev.unchk.campagne.entitySheared.SharedHandlerError;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
@AllArgsConstructor
public class AnneeServiceImp implements IService {

    private final AnneeRepository anneeRepository;
    private final AnneeMapperImp anneeMapperImp;
    private final SharedHandlerError sharedHandlerError;

    @Override
    public String saveAnnee(AnneeRequest anneeRequest, BindingResult bindingResult) throws RuntimeException {
//        sharedHandlerError.handlerValidate(bindingResult);
        AnneeAcademique a = anneeMapperImp.toAnnee(anneeRequest);
        return anneeRepository.save(anneeMapperImp.toAnnee(anneeRequest)).getId();
    }

    @Override
    public List<AnneeResponse> findAllAnnee() throws RuntimeException {
        return anneeMapperImp.toAnneesResponse(anneeRepository.findAll());
    }

    @Override
    public AnneeResponse findAnneeById(String anneeId) throws RuntimeException {
        AnneeAcademique annee = checkAnnee(anneeId);
        return anneeMapperImp.toAnneeResponse(annee);
    }

    @Override
    public Boolean updateAnnee(AnneeRequest anneeRequest, BindingResult bindingResult) throws RuntimeException {
        sharedHandlerError.handlerValidate(bindingResult);
        checkAnnee(anneeRequest.getId());
        anneeRepository.save(anneeMapperImp.toAnnee(anneeRequest));
        return true;
    }

    @Override
    public Boolean deleteAnnee(String anneeId) throws RuntimeException {
        checkAnnee(anneeId);
        anneeRepository.deleteById(anneeId);
        return true;
    }

    @Override
    public AnneeAcademique checkAnnee(String anneeId) throws AnneeNotFoundException {
        if (anneeId == null) throw new AnneeNotFoundException();
        return anneeRepository.findById(anneeId).orElseThrow(AnneeNotFoundException::new);
    }
}
