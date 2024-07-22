package org.sid.porttrack.repositories;

import org.sid.porttrack.entities.Grue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrueRepository extends JpaRepository<Grue, Long> {
    @Override
    boolean existsById(Long aLong);
}
