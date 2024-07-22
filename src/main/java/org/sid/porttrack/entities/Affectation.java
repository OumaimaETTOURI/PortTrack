package org.sid.porttrack.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.sid.porttrack.enums.PortAccostage;
import org.sid.porttrack.enums.ShiftDemarrage;
import org.sid.porttrack.enums.Terminal;
import org.sid.porttrack.enums.TypeMarchandise;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "affectations")
@Getter
@Setter

public class Affectation implements Serializable {
    @Id
    @GeneratedValue(generator = "AFFECTATION_GENERATOR")
    @SequenceGenerator(
        name = "AFFECTATION_GENERATOR",
        sequenceName = "AFFECTATION_ID_SEQ",
        allocationSize = 1)
    @Column(name = "affectation_id")
    private Long id;

    @Column(nullable = false)
    private String nomNavire;

    @Column(nullable = false)
    private int numeroNavire;

    @Enumerated(EnumType.STRING)
    private TypeMarchandise typeMarchandise;

    @Column(nullable = false)
    private Date dateAccostage;

    @Enumerated(EnumType.STRING)
    private ShiftDemarrage shiftDemarrage;

    @Enumerated(EnumType.STRING)
    private PortAccostage portAccostage;

    @Enumerated(EnumType.STRING)
    private Terminal terminal;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "affectation")
    private List<Grue> grues;
}
