package ca.test.rest.services.restfulwebservices.controller;

import ca.test.rest.services.restfulwebservices.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello user!";
    }

    @GetMapping("/hello-bean")
    public Message sayHelloBean() {
        return new Message("Custom message here!");
    }

    @GetMapping("/hello-bean/{name}")
    public Message sayHelloBeanPath(@PathVariable String name) {
        return new Message("Hello! " + name);
    }
}
