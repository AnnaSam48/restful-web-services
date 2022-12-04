package com.rest.microservices.restfulwebservices.jdbc_and_jpa.jpa;

import com.rest.microservices.restfulwebservices.jdbc_and_jpa.Course;
import com.rest.microservices.restfulwebservices.jdbc_and_jpa.SpringDataJpaRepository;
//import com.rest.microservices.restfulwebservices.jdbc_and_jpa.jdbc.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaCommandLineRunner implements org.springframework.boot.CommandLineRunner {

    //    @Autowired
//    private JdbcRepository jdbcRepository;
//    @Autowired
//    private JpaRepository repository;
    @Autowired
    private SpringDataJpaRepository springDataJpaRepository;

    @Override
    public void run(String... args) {
        springDataJpaRepository.save(new Course(1L, "AWS Practitioner Certification", "Stephan Marek"));
        springDataJpaRepository.save(new Course(2L, "Java Programmer Certification", "Dr. Sean Kennedy"));
        springDataJpaRepository.save(new Course(3L, "PythonBible", "Ziad Yehia"));
        springDataJpaRepository.save(new Course(4L, "Nonsense Masterclass", "Frump Coolter"));
        springDataJpaRepository.deleteById(4L);

        System.out.println(springDataJpaRepository.findById(2L));
        System.out.println(springDataJpaRepository.findAll());
        System.out.println(springDataJpaRepository.count());
        System.out.println(springDataJpaRepository.findByName("AWS Practitioner Certification"));
        System.out.println(springDataJpaRepository.findByAuthor("Ziad Yehia"));
    }
}
