package dev.unchk.campagne.motif.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MotifRequest {
    private String id;
    @NotEmpty
    private String description;

    //Fields Relations
    private String dossierId;
}
