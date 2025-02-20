package dev.unchk.campagne.dossier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierRepository extends JpaRepository<Dossier, String> {
    public Dossier findByUserId(String userId);
}
