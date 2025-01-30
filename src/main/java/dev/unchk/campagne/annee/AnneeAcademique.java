package dev.unchk.campagne.annee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.unchk.campagne.annonce.Annonce;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class AnneeAcademique {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String annee;

    //Relation Fields
    @OneToMany( mappedBy ="annee" , fetch = FetchType.EAGER , cascade = CascadeType.REMOVE )
    @JsonIgnoreProperties("annee")
    private List<Annonce> annonces;

    //Fields System
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
