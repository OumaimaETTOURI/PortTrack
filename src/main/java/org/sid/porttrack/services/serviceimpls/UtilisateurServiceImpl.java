package org.sid.porttrack.services.serviceimpls;

import lombok.extern.slf4j.Slf4j;
import org.sid.porttrack.entities.Utilisateur;
import org.sid.porttrack.exceptions.ResourceNotFoundException;
import org.sid.porttrack.repositories.UtilisateurRepository;
import org.sid.porttrack.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur with ID " + id + " not found"));
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur updateUtilisateur(Long id, Utilisateur updatedUtilisateur){
        return utilisateurRepository.findById(id)
                .map(existingUtilisateur -> {
                    existingUtilisateur.setNom(updatedUtilisateur.getNom());
                    existingUtilisateur.setPrenom(updatedUtilisateur.getPrenom());
                    existingUtilisateur.setLogin(updatedUtilisateur.getLogin());
                    existingUtilisateur.setMotDePasse(updatedUtilisateur.getMotDePasse());
                    existingUtilisateur.setTypeUtilisateur(updatedUtilisateur.getTypeUtilisateur());
                    existingUtilisateur.setAffectations(updatedUtilisateur.getAffectations());
                    return utilisateurRepository.save(existingUtilisateur);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Grue with ID " + id + " not found"));
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.findById(id).ifPresentOrElse(
                utilisateurRepository::delete,
                () -> {
                    throw new ResourceNotFoundException("Grue with ID " + id + " not found");
                }
        );
    }
}
