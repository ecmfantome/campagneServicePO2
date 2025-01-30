package dev.unchk.campagne.annee.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnneeRequest {
    private String id;
    @NotEmpty
    private String annee;
    //Fields Relations
}
