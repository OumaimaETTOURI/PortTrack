package org.sid.porttrack.controllers;

import org.sid.porttrack.entities.Affectation;
import org.sid.porttrack.services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("affectations")

public class AffectationController {
    
    private final AffectationService affectationService;

    @Autowired
    public AffectationController(AffectationService affectationService) {
        this.affectationService = affectationService;
    }
    @GetMapping("/")
    public List<Affectation> getAffectations() {
        List<Affectation> affectations = affectationService.getAllAffectations();
        return new ResponseEntity<>(affectations, HttpStatus.OK).getBody();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Affectation> getAffectationById(@PathVariable Long id) {
        Affectation affectation = affectationService.getAffectationById(id);
        if (affectation != null) {
            return new ResponseEntity<>(affectation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<Affectation> createAffectation(@RequestBody Affectation affectation) {
        Affectation newAffectation = affectationService.createAffectation(affectation);
        return new ResponseEntity<>(newAffectation, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Affectation> updateAffectation(@PathVariable Long id, @RequestBody Affectation affectation) {
        Affectation updatedAffectation = affectationService.updateAffectation(id, affectation);
        return new ResponseEntity<>(updatedAffectation, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAffectation(@PathVariable Long id) {
        affectationService.deleteAffectation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

