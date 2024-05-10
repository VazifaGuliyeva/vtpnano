package com.example.vtpnano.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@Entity(name="members")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {


    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(name="names")
    String name;
    @Column(name="surnames")
    String surname;
    @Column(name="genders")
    String gender;
    @Column(name="ages")
    Integer age;
    @Column(name="universities")
    String university;
    @Column(name="qualifications")
    String qualification;
    @Column(name="masterDegrees")
    Boolean masterDegree;

}
