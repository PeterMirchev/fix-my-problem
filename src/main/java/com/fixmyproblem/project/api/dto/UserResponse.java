package com.fixmyproblem.project.api.dto;

import com.fixmyproblem.project.model.Role;
import com.fixmyproblem.project.model.ticket.Ticket;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UserResponse {

    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Role role;
    private List<Ticket> tickets;
    private OffsetDateTime createdOn;
    private OffsetDateTime updatedOn;
    private boolean isActive;
}
