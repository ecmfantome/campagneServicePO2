package dev.unchk.campagne.dossier.dto;

import dev.unchk.campagne.dossier.Dossier.Status;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DossierRequest {
    private String id;
    @NotNull
    private String documentId;
    @NotNull
    private String userId;
    @NotNull
    private String annonceId;
    private Status status;
    private String message;

    //Fields Relations
}
