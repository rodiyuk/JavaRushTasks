package com.javarush.task.task30.task3008;

import java.io.Serializable;

public class Message implements Serializable {
    private final MessageType type;
    private final String data;
    private String userName;
    private String userNameSource;

    public String getUserName() {
        return userName;
    }

    public Message(MessageType type) {
        this.type = type;
        data = null;
    }

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    public Message(MessageType type, String data, String userNameDest, String userNameSource) {
        this.type = type;
        this.data = data;
        this.userName = userNameDest;
        this.userNameSource = userNameSource;
    }

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public String getUserNameSource() {
        return userNameSource;
    }
}
