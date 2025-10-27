package TripManagmentSystem.service.impl;

import TripManagmentSystem.model.User;
import TripManagmentSystem.repository.UserRepository;
import TripManagmentSystem.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(UUID id) {
        // Check if user exists before deleting
        if (userRepository.existsById(id)) {
            // Get user and clear trips first (cascade will delete them)
            Optional<User> userOpt = userRepository.findById(id);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                user.getTrips().clear(); // This will trigger orphanRemoval
                userRepository.save(user); // Save to trigger cascade
            }
            // Now delete the user
            userRepository.deleteById(id);
            userRepository.flush(); // Force immediate database commit
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }
}