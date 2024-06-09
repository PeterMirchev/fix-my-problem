package com.fixmyproblem.project.service.user;

import com.fixmyproblem.project.api.dto.UserRequest;
import com.fixmyproblem.project.api.dto.UserResponse;
import com.fixmyproblem.project.model.user.User;
import com.fixmyproblem.project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse create(UserRequest userRequest) {

        User user = userMapper.mapToUser(userRequest);
        User persisted = userRepository.save(user);

        return userMapper.mapToUserResponse(persisted);
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
