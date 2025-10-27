package TripManagmentSystem.controller;

import TripManagmentSystem.model.BusinessUser;
import TripManagmentSystem.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/business-users")
@CrossOrigin(origins = "http://localhost:3000")
public class BusinessUserController {

    private final UserRepository userRepository;

    public BusinessUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public BusinessUser createBusinessUser(@RequestBody BusinessUser user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<BusinessUser> getAllBusinessUsers() {
        return userRepository.findAll().stream()
                .filter(user -> user instanceof BusinessUser)
                .map(user -> (BusinessUser) user)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<BusinessUser> getBusinessUserById(@PathVariable UUID id) {
        return userRepository.findById(id)
                .filter(user -> user instanceof BusinessUser)
                .map(user -> (BusinessUser) user);
    }

    @DeleteMapping("/{id}")
    public void deleteBusinessUser(@PathVariable UUID id) {
        userRepository.deleteById(id);
    }
}
