package com.example.vtpnano.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity(name="users")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    UUID id;
    @Column(name="fulnames")
    String fullName;
    @Column(name="emails")
    String email;
    @Column(name="passwords")
    String password;
    @Column(name="is_Active")
    Boolean isActive;
}
