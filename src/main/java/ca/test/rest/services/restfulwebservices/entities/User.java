package ca.test.rest.services.restfulwebservices.entities;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public class User {
    private UUID id;
    @Size(min=2, message = "Name should contain minimum 2 characters")
    private String name;
    @Past(message = "date of birth can't be a date in future or null")
    private LocalDate birthDate;

    @Size(min=5, message = "Role must be provided")
    private UserRoles roles;

    public User(UUID id, String name, LocalDate birthDate, UserRoles roles) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public UserRoles getRoles() {
        return roles;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoles(UserRoles roles) {
        this.roles = roles;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", roles=" + roles +
                '}';
    }
}
