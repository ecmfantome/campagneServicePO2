package dev.unchk.campagne.motif;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.unchk.campagne.dossier.Dossier;
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
public class Motif {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String description;

    //Fields Relations
    @OneToOne
    @JsonIgnoreProperties("motif")
    private Dossier dossier;

    //Fields System
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}


