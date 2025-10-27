package TripManagmentSystem.controller;

import TripManagmentSystem.model.TravelAgent;
import TripManagmentSystem.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/travel-agents")
@CrossOrigin(origins = "http://localhost:3000")
public class TravelAgentController {

    private final UserRepository userRepository;

    public TravelAgentController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public TravelAgent createTravelAgent(@RequestBody TravelAgent agent) {
        return userRepository.save(agent);
    }

    @GetMapping
    public List<TravelAgent> getAllTravelAgents() {
        return userRepository.findAll().stream()
                .filter(user -> user instanceof TravelAgent)
                .map(user -> (TravelAgent) user)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<TravelAgent> getTravelAgentById(@PathVariable UUID id) {
        return userRepository.findById(id)
                .filter(user -> user instanceof TravelAgent)
                .map(user -> (TravelAgent) user);
    }

    @DeleteMapping("/{id}")
    public void deleteTravelAgent(@PathVariable UUID id) {
        userRepository.deleteById(id);
    }
}
