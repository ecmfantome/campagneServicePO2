package dev.unchk.campagne.annonce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.unchk.campagne.dossier.Dossier;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnnonceResponse {
    private String id;
    private String titre;
    private String description;
    private String AnnonceStatus;
    private String dateLimite;

    //Fields Relations
    @JsonIgnoreProperties("annonce")
    private List<Dossier> dossiers;
//    @JsonIgnoreProperties("annonce")
//    private Motif motif;
//    @JsonIgnoreProperties("annonces")
//    private AnneeAcademique annee;

}
