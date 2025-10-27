package TripManagmentSystem.service;

import TripManagmentSystem.model.Trip;
import java.util.List;
import java.util.Optional;

public interface TripService {
    Trip createTrip(Trip trip);
    List<Trip> getAllTrips();
    Optional<Trip> getTripById(Long id);
    void deleteTrip(Long id);
}