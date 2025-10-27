package TripManagmentSystem.controller;

import TripManagmentSystem.model.Trip;
import TripManagmentSystem.service.TripService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = "http://localhost:3000")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public Optional<Trip> getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
    }
}