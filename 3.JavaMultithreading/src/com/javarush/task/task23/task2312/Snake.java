package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        SnakeSection head = new SnakeSection(x, y);
        sections = new ArrayList<>();
        this.sections.add(head);
        isAlive = true;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (!isAlive) return;
        if (direction == SnakeDirection.DOWN) move(0, 1);
        else if (direction == SnakeDirection.LEFT) move(-1, 0);
        else if (direction == SnakeDirection.UP) move(0, -1);
        else if (direction == SnakeDirection.RIGHT) move(1, 0);
    }

    public void move(int dx, int dy) {

    }

    public void checkBorders(SnakeSection head) {
        if ((head.getY() < 0 || head.getY() >= Room.game.getHeight()) ||
                (head.getX() < 0 || head.getX() >= Room.game.getWidth())) isAlive = false;
    }

    public void checkBody(SnakeSection head){
        if (sections.contains(head)) isAlive = false;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public SnakeDirection getDirection() {
        return direction;
    }
}
