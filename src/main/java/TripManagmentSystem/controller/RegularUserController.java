package TripManagmentSystem.controller;

import TripManagmentSystem.model.RegularUser;
import TripManagmentSystem.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/regular-users")
@CrossOrigin(origins = "http://localhost:3000")
public class RegularUserController {

    private final UserRepository userRepository;

    public RegularUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public RegularUser createRegularUser(@RequestBody RegularUser user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<RegularUser> getAllRegularUsers() {
        return userRepository.findAll().stream()
                .filter(user -> user instanceof RegularUser)
                .map(user -> (RegularUser) user)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<RegularUser> getRegularUserById(@PathVariable UUID id) {
        return userRepository.findById(id)
                .filter(user -> user instanceof RegularUser)
                .map(user -> (RegularUser) user);
    }

    @DeleteMapping("/{id}")
    public void deleteRegularUser(@PathVariable UUID id) {
        userRepository.deleteById(id);
    }
}
