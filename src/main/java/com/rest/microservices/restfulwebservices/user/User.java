package com.rest.microservices.restfulwebservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private Integer id;
    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;
    @Past(message = "Date of birth should be in the past")
    private LocalDate birthDate;
}
