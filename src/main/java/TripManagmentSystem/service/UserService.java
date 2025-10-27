package TripManagmentSystem.service;

import TripManagmentSystem.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(UUID id);
    void deleteUser(UUID id);
}
