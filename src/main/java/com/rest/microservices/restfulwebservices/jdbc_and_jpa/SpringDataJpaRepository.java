package com.rest.microservices.restfulwebservices.jdbc_and_jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course>findByAuthor(String author);
    List<Course>findByName(String name);
}
