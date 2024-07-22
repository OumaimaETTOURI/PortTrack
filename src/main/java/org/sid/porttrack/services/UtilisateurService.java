package org.sid.porttrack.services;

import org.sid.porttrack.entities.Grue;
import org.sid.porttrack.entities.Utilisateur;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public interface UtilisateurService {
    List<Utilisateur> getAllUtilisateurs();

    Utilisateur getUtilisateurById(Long id);

    Utilisateur createUtilisateur(Utilisateur utilisateur);

    Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur);

    void deleteUtilisateur(Long id);
}
