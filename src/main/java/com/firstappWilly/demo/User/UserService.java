package com.firstappWilly.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(Math.toIntExact(id));
        return user.orElse(null); // Return null if user not found
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void removeUser(User user) {
        userRepository.delete(user);
    }

}
