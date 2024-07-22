package org.sid.porttrack.daos;

import lombok.Getter;
import lombok.Setter;
import org.sid.porttrack.entities.Affectation;
import org.sid.porttrack.enums.TypeUtilisateur;

import java.util.List;

@Getter
@Setter

public class UtilisateurDAO {
    private Long id;
    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;
    private TypeUtilisateur typeUtilisateur;
    private List<Affectation> affectations;
    public UtilisateurDAO() {}
}
