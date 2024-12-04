package com.desafio.agenciaviagem.services;

import com.desafio.agenciaviagem.entities.Destination;
import com.desafio.agenciaviagem.repositories.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public Destination addDestination(Destination destination) {
        destination.setAverageRating(0.0);
        destination.setTotalRatings(0);
        destination.setRatingSum(0);
        return destinationRepository.save(destination);
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public List<Destination> searchDestinations(String name, String location) {
        return destinationRepository.findAll().stream()
                .filter(destination -> (name == null || destination.getName().contains(name)) &&
                        (location == null || destination.getLocation().contains(location)))
                .toList();
    }

    public Destination getDestinationById(Long id) {
        return destinationRepository.findById(id)
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

        return destinationRepository.save(destination);
    }

    public void deleteDestination(Long id) {
        if (!destinationRepository.existsById(id)) {
            throw new RuntimeException("Destination not found");
        }
        destinationRepository.deleteById(id);
    }
}
