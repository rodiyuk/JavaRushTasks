package com.javarush.task.task30.task3008;

import java.io.Serializable;

public class Message implements Serializable {
    private final MessageType type;
    private final String data;

    public String getUserName() {
        return userName;
    }

    private String userName;

    public Message(MessageType type) {
        this.type = type;
        data = null;
    }

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    public Message(MessageType type, String data, String userName) {
        this.type = type;
        this.data = data;
        this.userName = userName;
    }

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
