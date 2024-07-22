package org.sid.porttrack.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.sid.porttrack.enums.NomGrue;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "grues")
@Getter
@Setter

public class Grue implements Serializable {
    @Id
    @GeneratedValue(generator = "GRUE_GENERATOR")
    @SequenceGenerator(
            name = "GRUE_GENERATOR",
            sequenceName = "GRUE_ID_SEQ",
            allocationSize = 1)
    @Column(name = "grue_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private NomGrue nomGrue;

    @Column(nullable = false)
    private Date dateDisponibilite;

    @ManyToOne
    @JoinColumn(name = "affectation_id", nullable = false)
    private Affectation affectation;
}
