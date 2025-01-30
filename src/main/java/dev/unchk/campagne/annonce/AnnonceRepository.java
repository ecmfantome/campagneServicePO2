package dev.unchk.campagne.annonce;

import dev.unchk.campagne.annee.AnneeAcademique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, String> {
    List<Annonce> findAnnonceByAnnee(AnneeAcademique anneeAcademique);
}
