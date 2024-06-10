package com.fixmyproblem.project.api.controller;

import com.fixmyproblem.project.api.dto.UserRequest;
import com.fixmyproblem.project.api.dto.UserResponse;
import com.fixmyproblem.project.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fixmyproblem.project.api.BasePaths.*;

@RestController
@RequestMapping(BASE_PATH + USER_BASE_PATH)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(CREATE_USER)
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {

        UserResponse userResponse = userService.create(userRequest);

        return ResponseEntity.ok(userResponse);
    }
 }
