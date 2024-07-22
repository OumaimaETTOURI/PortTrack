package org.sid.porttrack.services.serviceimpls;

import lombok.extern.slf4j.Slf4j;
import org.sid.porttrack.entities.Affectation;
import org.sid.porttrack.exceptions.ResourceNotFoundException;
import org.sid.porttrack.repositories.AffectationRepository;
import org.sid.porttrack.services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j

public class AffectationServiceImpl implements AffectationService {
    @Autowired
    private AffectationRepository affectationRepository;

    @Override
    public List<Affectation> getAllAffectations() {
        return affectationRepository.findAll();
    }

    @Override
    public Affectation getAffectationById(Long id){
        return affectationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Affectation with ID " + id + " not found"));
    }
    @Override
    public Affectation createAffectation(Affectation affectation) {
        return affectationRepository.save(affectation);
    }
    @Override
    public Affectation updateAffectation(Long id, Affectation updatedAffectation) {
        return affectationRepository.findById(id)
                .map(existingAffectation -> {
                    existingAffectation.setNomNavire(updatedAffectation.getNomNavire());
                    existingAffectation.setNumeroNavire(updatedAffectation.getNumeroNavire());
                    existingAffectation.setTypeMarchandise(updatedAffectation.getTypeMarchandise());
                    existingAffectation.setDateAccostage(updatedAffectation.getDateAccostage());
                    existingAffectation.setShiftDemarrage(updatedAffectation.getShiftDemarrage());
                    existingAffectation.setPortAccostage(updatedAffectation.getPortAccostage());
                    existingAffectation.setTerminal(updatedAffectation.getTerminal());
                    existingAffectation.setUtilisateur(updatedAffectation.getUtilisateur());
                    existingAffectation.setGrues(updatedAffectation.getGrues());
                    return affectationRepository.save(existingAffectation);
        })
                .orElseThrow(() -> new ResourceNotFoundException("Affectation with ID " + id + " not found"));
    }
    @Override
    public void deleteAffectation(Long id){
        affectationRepository.findById(id).ifPresentOrElse(
                affectationRepository::delete,
                () -> {
                    throw new ResourceNotFoundException("Affectation with ID " + id + " not found");
                }
        );
    }
}
