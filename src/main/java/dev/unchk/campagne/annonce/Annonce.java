package dev.unchk.campagne.annonce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.unchk.campagne.annee.AnneeAcademique;
import dev.unchk.campagne.motif.Motif;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String titre;

    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AnnonceStatus status;

    private String dateLimite;

    //Relation Fields

    @ManyToOne
    @JsonIgnoreProperties("annonces")
    private AnneeAcademique annee;

    @OneToOne(mappedBy = "annonce", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("annonce")
    private Motif motif;

    //Fields System
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    enum AnnonceStatus {
        OUVERT , FERMER
    }
}
