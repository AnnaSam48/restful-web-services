package com.rest.microservices.restfulwebservices.jdbc_and_jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    private long id;
    private String name;
    private String author;
}
