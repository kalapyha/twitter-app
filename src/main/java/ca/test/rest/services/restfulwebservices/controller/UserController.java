package ca.test.rest.services.restfulwebservices.controller;

import ca.test.rest.services.restfulwebservices.dao.UserDaoService;
import ca.test.rest.services.restfulwebservices.entities.User;
import ca.test.rest.services.restfulwebservices.entities.UserRoles;
import ca.test.rest.services.restfulwebservices.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User retrieveUserById(@PathVariable UUID id) {
        User user = userDaoService.getUserById(id);
        if(user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }

    @GetMapping("/users/role={role}")
    public List<User> retrieveUserById(@PathVariable UserRoles role) {
        return userDaoService.getUsersByRole(role);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        userDaoService.removeUserById(id);
    }

}
