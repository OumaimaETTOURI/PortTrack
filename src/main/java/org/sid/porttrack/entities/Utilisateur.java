package org.sid.porttrack.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.sid.porttrack.enums.TypeUtilisateur;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "utilisateurs")
@Getter
@Setter

public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(generator = "UTILISATEUR_GENERATOR")
    @SequenceGenerator(
            name = "UTILISATEUR_GENERATOR",
            sequenceName = "UTILISATEUR_ID_SEQ",
            allocationSize = 1)
    @Column(name = "utilisateur_id")
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private TypeUtilisateur typeUtilisateur;

    @OneToMany(mappedBy = "utilisateur")
    private List<Affectation> affectations;
}
