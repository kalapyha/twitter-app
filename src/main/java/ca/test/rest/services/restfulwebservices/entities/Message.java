package ca.test.rest.services.restfulwebservices.entities;

import org.springframework.stereotype.Component;

public class Message {

    private String msg;
    public Message(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return this.msg;
    }
}
