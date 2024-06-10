package com.fixmyproblem.project.model.queue;

import com.fixmyproblem.project.model.ticket.Ticket;
import com.fixmyproblem.project.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String queueName;
    @ManyToMany(targetEntity = Ticket.class)
    private List<Ticket> tickets;
    @ManyToMany(targetEntity = User.class)
    private List<User> users;
}
