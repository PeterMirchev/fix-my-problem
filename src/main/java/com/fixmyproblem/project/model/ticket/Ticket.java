package com.fixmyproblem.project.model.ticket;

import com.fixmyproblem.project.model.CaseStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @Column(name = "requestor_username")
    private String requestorUsername;
    @NotNull
    @Column(name = "owner_username")
    private String ownerUsername;
    @NotNull
    private String Subject;
    @NotNull
    private String description;
    @ElementCollection
    @Column(name = "comments")
    private List<String> comment;
    @ElementCollection
    @Column(name = "internal_comments")
    private List<String> internalCommends;
    @Column(name = "created_on")
    private OffsetDateTime createdOn;
    @Column(name = "updated_on")
    private OffsetDateTime updatedOn;
    @Column(name = "closed_on")
    private OffsetDateTime closedOn;
    @Enumerated
    private CaseStatus status;

}
