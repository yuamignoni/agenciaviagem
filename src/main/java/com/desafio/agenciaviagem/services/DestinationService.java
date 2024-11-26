package com.desafio.agenciaviagem.services;

import com.desafio.agenciaviagem.entities.Destination;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationService {

    private List<Destination> destinations = new ArrayList<>();
    private Long nextId = 1L;

    public Destination addDestination(Destination destination) {
        destination.setId(nextId++);
        destination.setAverageRating(0.0);
        destination.setTotalRatings(0);
        destination.setRatingSum(0);
        destinations.add(destination);
        return destination;
    }

    public List<Destination> getAllDestinations() {
        return destinations;
    }

    public List<Destination> searchDestinations(String name, String location) {
        return destinations.stream()
                .filter(destination -> (name == null || destination.getName().contains(name)) &&
                        (location == null || destination.getLocation().contains(location)))
                .collect(Collectors.toList());
    }

    public Destination getDestinationById(Long id) {
        return destinations.stream()
                .filter(destination -> destination.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Destination not found"));
    }

    public Destination rateDestination(Long id, int rating) {
        if (rating < 1 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 1 and 10");
        }
        Destination destination = getDestinationById(id);
        destination.setRatingSum(destination.getRatingSum() + rating);
        destination.setTotalRatings(destination.getTotalRatings() + 1);
        destination.setAverageRating(destination.getRatingSum() / (double) destination.getTotalRatings());
        return destination;
    }

    public void deleteDestination(Long id) {
        destinations.removeIf(destination -> destination.getId().equals(id));
    }
}
