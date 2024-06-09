package com.fixmyproblem.project.service.user;

import com.fixmyproblem.project.api.dto.UserRequest;
import com.fixmyproblem.project.api.dto.UserResponse;
import com.fixmyproblem.project.model.user.User;
import com.fixmyproblem.project.repository.UserRepository;
import com.fixmyproblem.project.service.email.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EmailService emailService;

    public UserService(UserRepository userRepository,
                       UserMapper userMapper,
                       EmailService emailService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.emailService = emailService;
    }

    public UserResponse create(UserRequest userRequest) {

        User user = userMapper.mapToUser(userRequest);
        User persisted = userRepository.save(user);

        try {
            emailService.sendSimpleMessage(
                    userRequest.getEmail(),
                    "Welcome to FixMyProblem",
                    "Hello " + userRequest.getFirstName() + ", welcome to FixMyProblem!"
            );
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Optionally, handle the exception (e.g., retry, alert admin, etc.)
        }

        return userMapper.mapToUserResponse(persisted);
    }

    private void sendWelcomeEmail(User persisted) {

        String subject = "Welcome to Fix My Problem!";
        String text = "Dear " + persisted.getFirstName() + ",\n\nThank you for your registration!\nYou are now part of Fix My Problem." +
                "\n\nBest Regards,\nFixMyProblem Team";
        emailService.sendSimpleMessage(persisted.getEmail(), subject, text);
    }

    public UserResponse update(UserRequest userRequest) {

        return null;
    }

    public void deleteByEmail(String email) {

    }

    public List<UserResponse> getAllUsers() {

        return null;
    }

    public UserResponse getUserById(UUID id){

        return null;
    }

    public UserResponse getUserByEmail(String email){

        return null;
    }

    public UserResponse getUserByUsername(String username){

        return null;
    }

    public List<UserResponse> getUserByFirstName(String firstName){

        return null;
    }

    public List<UserResponse> getUserByLastName(String lastName){

        return null;
    }

}
