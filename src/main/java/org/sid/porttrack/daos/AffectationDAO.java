package org.sid.porttrack.daos;

import lombok.Getter;
import lombok.Setter;
import org.sid.porttrack.entities.Grue;
import org.sid.porttrack.entities.Utilisateur;
import org.sid.porttrack.enums.Terminal;
import org.sid.porttrack.enums.TypeMarchandise;

import java.util.Date;
import java.util.List;

@Getter
@Setter

public class AffectationDAO {
private Long id;
private String nomNavire;
private String numeroNavire;
private TypeMarchandise typeMarchandise;
private Date dateAccostage;
private Terminal terminal;
private Utilisateur utilisateur;
private List<Grue> grues;
public AffectationDAO() {}
}
