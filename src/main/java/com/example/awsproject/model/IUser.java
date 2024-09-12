package com.example.awsproject.model;

import com.example.awsproject.model.enums.Role;
import com.example.awsproject.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Table("users")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString(exclude = "events")
public class IUser {

    @Id
    private Long id;
    private String username;
    @Column("role")
    private Role role;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Transient
    private List<Event> events;

    @Column("created_at")
    @CreatedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

    @Column("updated_at")
    @LastModifiedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updatedAt;

}
