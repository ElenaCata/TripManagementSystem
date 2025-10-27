package TripManagmentSystem.service.impl;

import TripManagmentSystem.model.Trip;
import TripManagmentSystem.repository.TripRepository;
import TripManagmentSystem.service.TripService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip createTrip(Trip trip) {
        if (trip.getName() == null || trip.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Trip name cannot be empty");
        }
        if (trip.getDestination() == null || trip.getDestination().trim().isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be empty");
        }
        return tripRepository.save(trip);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

    @Override
    public void deleteTrip(Long id) {
        if (tripRepository.existsById(id)) {
            tripRepository.deleteById(id);
            tripRepository.flush();
        } else {
            throw new RuntimeException("Trip with ID " + id + " not found");
        }
    }

    // Find trips by destination
    public List<Trip> findTripsByDestination(String destination) {
        return tripRepository.findAll().stream()
                .filter(trip -> trip.getDestination() != null && 
                               trip.getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());
    }

    // Get future trips
    public List<Trip> findFutureTrips() {
        return tripRepository.findAll().stream()
                .filter(Trip::isFuture)
                .collect(Collectors.toList());
    }

    // Calculate total price
    public BigDecimal calculateTotalPrice() {
        return tripRepository.findAll().stream()
                .map(Trip::getPrice)
                .filter(price -> price != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Get unique destinations
    public List<String> getUniqueDestinations() {
        return tripRepository.findAll().stream()
                .map(Trip::getDestination)
                .filter(dest -> dest != null && !dest.trim().isEmpty())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}