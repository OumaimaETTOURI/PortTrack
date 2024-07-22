package org.sid.porttrack.repositories;

import org.sid.porttrack.entities.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffectationRepository extends JpaRepository<Affectation, Long> {
    @Override
    boolean existsById(Long aLong);

}
