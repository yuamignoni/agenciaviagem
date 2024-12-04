package com.desafio.agenciaviagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafio.agenciaviagem.entities.Destination;
import com.desafio.agenciaviagem.services.DestinationService;

import java.util.List;

@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @PostMapping
    public ResponseEntity<Destination> addDestination(@RequestBody Destination destination) {
        return ResponseEntity.ok(destinationService.addDestination(destination));
    }

    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        return ResponseEntity.ok(destinationService.getAllDestinations());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Destination>> searchDestinations(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location) {
        return ResponseEntity.ok(destinationService.searchDestinations(name, location));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable Long id) {
        return ResponseEntity.ok(destinationService.getDestinationById(id));
    }

    @PatchMapping("/{id}/rate")
    public ResponseEntity<Destination> rateDestination(@PathVariable Long id, @RequestParam int rating) {
        return ResponseEntity.ok(destinationService.rateDestination(id, rating));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return ResponseEntity.noContent().build();
    }
}
