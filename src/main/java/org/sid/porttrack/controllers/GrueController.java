package org.sid.porttrack.controllers;

import org.sid.porttrack.entities.Affectation;
import org.sid.porttrack.entities.Grue;
import org.sid.porttrack.services.AffectationService;
import org.sid.porttrack.services.GrueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grues")

public class GrueController {
    private final GrueService grueService;

    @Autowired
    public GrueController(GrueService grueService) {
        this.grueService = grueService;
    }
    @GetMapping("/")
    public List<Grue> getGrues() {
        List<Grue> grues = grueService.getAllGrues();
        return new ResponseEntity<>(grues, HttpStatus.OK).getBody();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Grue> getGrueById(@PathVariable Long id) {
        Grue grue = grueService.getGrueById(id);
        if (grue != null) {
            return new ResponseEntity<>(grue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<Grue> createGrue(@RequestBody Grue grue) {
        Grue newGrue = grueService.createGrue(grue);
        return new ResponseEntity<>(newGrue, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Grue> updateGrue(@PathVariable Long id, @RequestBody Grue grue) {
        Grue updatedGrue = grueService.updateGrue(id, grue);
        return new ResponseEntity<>(updatedGrue, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGrue(@PathVariable Long id) {
        grueService.deleteGrue(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
