package dev.unchk.campagne.motif.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MotifResponse {
    private String id;
    private String description;

    //Fields Relations
}
