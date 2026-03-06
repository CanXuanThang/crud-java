package com.study_java.crud.service.user;

import com.study_java.crud.exceptions.ResourceNotFoundException;
import com.study_java.crud.modals.User;
import com.study_java.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Email not found"));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresentOrElse(userRepository::delete ,() -> {
           throw new ResourceNotFoundException("User not found");
        });
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
