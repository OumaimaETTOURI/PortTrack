package org.sid.porttrack.services;

import org.sid.porttrack.entities.Affectation;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public interface AffectationService {
    List<Affectation> getAllAffectations();

    Affectation getAffectationById(Long id);

    Affectation createAffectation(Affectation affectation);

    Affectation updateAffectation(Long id, Affectation affectation);

    void deleteAffectation(Long id);
}
