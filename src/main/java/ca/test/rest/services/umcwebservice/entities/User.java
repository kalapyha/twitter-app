package ca.test.rest.services.umcwebservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "ums")
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    @Size(min=2, message = "Name should contain minimum 2 characters")
    private String name;

    @Email
    private String email;
    @Past(message = "date of creation can't be a date in future or null")
    private LocalDate created;

    // TODO need to link user roles
    // TODO need to link user subscription and followers

    public User(UUID id, String name, String email, LocalDate created) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.created = created;
    }

    public User() {

    }

    public UUID getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                '}';
    }
}
