package TripManagmentSystem.service;

import TripManagmentSystem.model.Trip;
import TripManagmentSystem.repository.TripRepository;
import TripManagmentSystem.service.impl.TripServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TripServiceTest {

    private TripRepository tripRepository;
    private TripService tripService;

    @BeforeEach
    void setUp() {

        tripRepository = Mockito.mock(TripRepository.class);
        tripService = new TripServiceImpl(tripRepository);
    }

    @Test
    void testCreateTrip() {
        Trip trip = new Trip();
        trip.setName("Test Trip");
        trip.setDestination("Paris");

        when(tripRepository.save(trip)).thenReturn(trip);

        Trip savedTrip = tripService.createTrip(trip);

        assertEquals("Test Trip", savedTrip.getName());
        assertEquals("Paris", savedTrip.getDestination());
        verify(tripRepository, times(1)).save(trip);
    }

    @Test
    void testGetTripById() {
        Long id = 1L;
        Trip trip = new Trip();
        trip.setName("Trip 1");

        when(tripRepository.findById(id)).thenReturn(Optional.of(trip));

        Optional<Trip> result = tripService.getTripById(id);

        assertTrue(result.isPresent());
        assertEquals("Trip 1", result.get().getName());
        verify(tripRepository, times(1)).findById(id);
    }

    @Test
    void testGetAllTrips() {
        Trip trip1 = new Trip();
        trip1.setName("Trip A");
        Trip trip2 = new Trip();
        trip2.setName("Trip B");

        when(tripRepository.findAll()).thenReturn(java.util.List.of(trip1, trip2));

        var trips = tripService.getAllTrips();

        assertEquals(2, trips.size());
        assertEquals("Trip A", trips.get(0).getName());
        assertEquals("Trip B", trips.get(1).getName());
        verify(tripRepository, times(1)).findAll();
    }

    @Test
    void testDeleteTrip() {
        Long id = 1L;

        when(tripRepository.existsById(id)).thenReturn(true);
        doNothing().when(tripRepository).deleteById(id);

        tripService.deleteTrip(id);

        verify(tripRepository, times(1)).existsById(id);
        verify(tripRepository, times(1)).deleteById(id);
    }
}
