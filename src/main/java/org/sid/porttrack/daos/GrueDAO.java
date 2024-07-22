package org.sid.porttrack.daos;

import lombok.Getter;
import lombok.Setter;
import org.sid.porttrack.entities.Affectation;
import org.sid.porttrack.enums.NomGrue;
import java.util.Date;

@Getter
@Setter

public class GrueDAO {
    private Long id;
    private NomGrue nomGrue;
    private Date dateDisponibilite;
    private Affectation affectation;
    public GrueDAO() {}
}
