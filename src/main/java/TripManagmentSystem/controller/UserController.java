package TripManagmentSystem.controller;

import TripManagmentSystem.model.User;
import TripManagmentSystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * UserController - READ ONLY
 * For creating users, use:
 * - /api/regular-users (RegularUserController)
 * - /api/business-users (BusinessUserController)
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get all users (both Regular and Business)
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Get user by ID
     */
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    /**
     * Delete user by ID
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}