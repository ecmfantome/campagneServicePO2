package dev.unchk.campagne.dossier;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.unchk.campagne.annonce.Annonce;
import dev.unchk.campagne.motif.Motif;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private Status status = Status.WAITING;

    private String message;

    private String documentId;

    private String userId;

    // Relation Fields

    @ManyToOne
    @JsonIgnoreProperties("dossiers")
    private Annonce annonce;

    @OneToOne(mappedBy = "dossier", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("dossier")
    private Motif motif;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public enum Status {
        WAITING, VALID, REJECTED
    }
}
