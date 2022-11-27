package com.rest.microservices.restfulwebservices.user;

import com.rest.microservices.restfulwebservices.exception.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserDaoService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userService.findUser(id);

        if (user == null) {
            throw new UserNotFoundException("User with id: " + id + " not found");
        }

        return user;
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(createdUser.getId())
                                                  .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Object> DeleteUser(@PathVariable int id) {
        if (userService.findUser(id) == null) {
            throw new UserNotFoundException("User with id: " + id + " not found");
        }

        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
