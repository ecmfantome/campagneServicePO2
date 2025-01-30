package dev.unchk.campagne.annonce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.unchk.campagne.annee.AnneeAcademique;
import dev.unchk.campagne.motif.Motif;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    private Motif motif;
//    @JsonIgnoreProperties("annonces")
//    private AnneeAcademique annee;

}
