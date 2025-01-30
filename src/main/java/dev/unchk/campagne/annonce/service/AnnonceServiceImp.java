package dev.unchk.campagne.annonce.service;

import dev.unchk.campagne.annee.AnneeAcademique;
import dev.unchk.campagne.annonce.Annonce;
import dev.unchk.campagne.annonce.AnnonceRepository;
import dev.unchk.campagne.annonce.customeException.AnnonceNotFoundException;
import dev.unchk.campagne.annonce.dto.AnnonceRequest;
import dev.unchk.campagne.annonce.dto.AnnonceResponse;
import dev.unchk.campagne.annonce.mapper.AnnonceMapperImp;
import dev.unchk.campagne.entitySheared.SharedHandlerError;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
@AllArgsConstructor
public class AnnonceServiceImp implements IService {

    private final AnnonceRepository annonceRepository;
    private final AnnonceMapperImp annonceMapperImp;
    private final SharedHandlerError sharedHandlerError;

    @Override
    public String saveAnnonce(AnnonceRequest annonceRequest, BindingResult bindingResult) throws RuntimeException {
        sharedHandlerError.handlerValidate(bindingResult);
        return annonceRepository.save(annonceMapperImp.toAnnonce(annonceRequest)).getId();
    }

    @Override
    public List<AnnonceResponse> findAllAnnonceByAnneeId(String anneeId) {
        AnneeAcademique anneeAcademique = AnneeAcademique.builder().id(anneeId).build();
        return annonceMapperImp.toAnnoncesResponse(annonceRepository.findAnnonceByAnnee(anneeAcademique));
    }

    @Override
    public AnnonceResponse findAnnonceById(String annonceId) throws RuntimeException {
        Annonce annonce = checkAnnonce(annonceId);
        return  annonceMapperImp.toAnnonceResponse(annonce);
    }

    @Override
    public Boolean updateAnnonce(AnnonceRequest annonceRequest, BindingResult bindingResult) throws RuntimeException {
        sharedHandlerError.handlerValidate(bindingResult); 
        checkAnnonce(annonceRequest.getId());
        annonceRepository.save(annonceMapperImp.toAnnonce(annonceRequest));
        return true;
    }

    @Override
    public Boolean deleteAnnonce(String annonceId) throws RuntimeException {
        checkAnnonce(annonceId);
        annonceRepository.deleteById(annonceId);
        return true;
    }

    @Override
    public Annonce checkAnnonce(String annonceId) throws AnnonceNotFoundException {
        if (annonceId == null) throw new AnnonceNotFoundException();
        return annonceRepository.findById(annonceId).orElseThrow(AnnonceNotFoundException::new);
    }
}
