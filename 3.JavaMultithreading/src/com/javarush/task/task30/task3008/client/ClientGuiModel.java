package com.javarush.task.task30.task3008.client;

import javax.swing.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ClientGuiModel {
    private final Set<String> allUserNames = new HashSet<>();
    private final Set<JButton> allUsersButtons = new HashSet<>();
    private String newMessage;

    public Set<JButton> getAllUsersButtons() {
        return Collections.unmodifiableSet(allUsersButtons);
    }
    public void addUser(String newUserName){
        allUserNames.add(newUserName);
    }
    public void addUser(JButton jButton){
        allUsersButtons.add(jButton);
    }
    public void deleteUser(String userName){
        allUserNames.remove(userName);
    }
    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }
}
