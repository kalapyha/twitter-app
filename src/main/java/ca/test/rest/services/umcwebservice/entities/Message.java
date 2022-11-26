package ca.test.rest.services.umcwebservice.entities;

public class Message {

    private String msg;
    public Message(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return this.msg;
    }
}
