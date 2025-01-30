package dev.unchk.campagne.annee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.unchk.campagne.annonce.Annonce;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnneeResponse {
    private String id;
    private String annee;

    //Fields Relations
    @JsonIgnoreProperties("annee")
    List<Annonce> annonces;
}
