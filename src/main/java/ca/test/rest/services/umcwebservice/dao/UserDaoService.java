package ca.test.rest.services.umcwebservice.dao;

import ca.test.rest.services.umcwebservice.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

// TODO no need for this component? Retrieving data from DB in UserController now
@Component
public class UserDaoService {
    private static List<User> users = new ArrayList();

    {
        users.add(new User(UUID.randomUUID(),"John", "john@gmail.com", LocalDate.now().minusYears(1)));
        users.add(new User(UUID.randomUUID(),"Bob", "bob@yahoo.com", LocalDate.now().minusYears(4)));
        users.add(new User(UUID.randomUUID(),"Michael", "michael404@igo.com", LocalDate.now().minusYears(3)));
    }

    public List<User> getUsers() {
        return users;
    }


    public User getUserById(UUID id) {
        return users.stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);
    }

    public void removeUserById(UUID id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User saveUser(User user) {
        user.setId(UUID.randomUUID());
        users.add(user);
        return user;
    }
}



