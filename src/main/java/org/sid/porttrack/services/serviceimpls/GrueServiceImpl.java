package org.sid.porttrack.services.serviceimpls;

import lombok.extern.slf4j.Slf4j;
import org.sid.porttrack.entities.Grue;
import org.sid.porttrack.exceptions.ResourceNotFoundException;
import org.sid.porttrack.repositories.GrueRepository;
import org.sid.porttrack.services.GrueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class GrueServiceImpl implements GrueService {
    @Autowired
    private GrueRepository grueRepository;

    @Override
    public List<Grue> getAllGrues() {
        return grueRepository.findAll();
    }

    @Override
    public Grue getGrueById(Long id) {
        return grueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grue with ID " + id + " not found"));
    }

    @Override
    public Grue createGrue(Grue grue) {
        return grueRepository.save(grue);
    }

    @Override
    public Grue updateGrue(Long id, Grue updatedgrue) {
        return grueRepository.findById(id)
                .map(existingGrue-> {
                    existingGrue.setNomGrue(updatedgrue.getNomGrue());
                    existingGrue.setDateDisponibilite(updatedgrue.getDateDisponibilite());
                    existingGrue.setAffectation(updatedgrue.getAffectation());
                    return grueRepository.save(existingGrue);
                })
        .orElseThrow(() -> new ResourceNotFoundException("Grue with ID " + id + " not found"));
    }

    @Override
    public void deleteGrue(Long id) {
        grueRepository.findById(id).ifPresentOrElse(
                grueRepository::delete,
                () -> {
                    throw new ResourceNotFoundException("Grue with ID " + id + " not found");
                }
        );
    }


}
