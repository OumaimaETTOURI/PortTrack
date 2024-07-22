package org.sid.porttrack.services;

import org.sid.porttrack.entities.Grue;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public interface GrueService {
    List<Grue> getAllGrues();

    Grue getGrueById(Long id);

    Grue createGrue(Grue grue);

    Grue updateGrue(Long id, Grue grue);

    void deleteGrue(Long id);
}
