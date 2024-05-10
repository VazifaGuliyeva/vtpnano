package com.example.vtpnano.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberDto {


    UUID id;
    String name;
    String surname;
    String gender;
    Integer age;
    String university;
    String qualification;
    Boolean masterDegree;
}
