package com.fixmyproblem.project.service.user;

import com.fixmyproblem.project.api.dto.UserRequest;
import com.fixmyproblem.project.api.dto.UserResponse;
import com.fixmyproblem.project.model.UserModel;
import com.fixmyproblem.project.model.user.User;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class UserMapper {

    public UserResponse mapToUserResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .email(user.getEmail())
                .userModel(user.getUserModel())
                .tickets(user.getTickets())
                .createdOn(user.getCreatedOn())
                .updatedOn(user.getUpdatedOn())
                .isActive(user.isActive())
                .build();
    }

    public User mapToUser(UserRequest userRequest) {

        return User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .username(userRequest.getFirstName() + "." + userRequest.getLastName())
                .email(userRequest.getEmail())
                .userModel(UserModel.USER)
                .createdOn(OffsetDateTime.now())
                .updatedOn(OffsetDateTime.now())
                .isActive(true)
                .build();
    }
}
