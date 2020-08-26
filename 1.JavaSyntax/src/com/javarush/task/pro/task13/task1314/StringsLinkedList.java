package com.javarush.task.pro.task13.task1314;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();
    public int size;

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            size++;
            return;
        }

        Node node = new Node();
        node.value = value;

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
        size++;
    }

    public String get(int index) {
        //напишите тут ваш код
        if (index < 0 || index > size) return null;
        if (index == 0) return first.next.value;
        Node node = first.next;
        for (int i = 1; i <= index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
