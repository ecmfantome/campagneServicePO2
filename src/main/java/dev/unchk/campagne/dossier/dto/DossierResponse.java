package dev.unchk.campagne.dossier.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.unchk.campagne.annonce.Annonce;
import dev.unchk.campagne.dossier.Dossier.Status;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DossierResponse {
    private String id;
    private String documentId;
    private Status status;
    private String message;

    @JsonIgnoreProperties("dossiers")
    private Annonce annonce;
}
