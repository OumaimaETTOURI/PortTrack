package org.sid.porttrack.repositories;

import org.sid.porttrack.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Override
    boolean existsById(Long aLong);

}
