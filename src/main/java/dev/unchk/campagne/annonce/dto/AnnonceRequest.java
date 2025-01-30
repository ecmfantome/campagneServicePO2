package dev.unchk.campagne.annonce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.unchk.campagne.annee.AnneeAcademique;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnnonceRequest {
    private String id;
    @NotEmpty
    private String titre;

    private String description;

   @NotNull
    private String AnnonceStatus;
    @NotNull
    private String dateLimite;


    //Fields Relations be5250b8-1da6-4b3b-96dd-3c6d4de82ab0
  private   String academiqueId;
}
