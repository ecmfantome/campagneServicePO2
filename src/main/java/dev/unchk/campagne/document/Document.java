package dev.unchk.campagne.document;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    @Lob
    private byte[] content;
    private String contentType;

    // Relation Fields
//    @OneToMany(mappedBy = "annee", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    @JsonIgnoreProperties("annee")
//    private List<Annonce> annonces;

    // Relation Fields
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
