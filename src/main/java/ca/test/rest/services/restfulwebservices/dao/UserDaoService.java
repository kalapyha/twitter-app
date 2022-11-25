package ca.test.rest.services.restfulwebservices.dao;

import ca.test.rest.services.restfulwebservices.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList();

    {
        users.add(new User(UUID.randomUUID(),"John", LocalDate.now().minusYears(51)));
        users.add(new User(UUID.randomUUID(),"Bob", LocalDate.now().minusYears(31)));
        users.add(new User(UUID.randomUUID(),"Michael", LocalDate.now().minusYears(36)));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(UUID id) {
        return users.stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);
    }

    public User saveUser(User user) {
        user.setId(UUID.randomUUID());
        users.add(user);
        return user;
    }
}



