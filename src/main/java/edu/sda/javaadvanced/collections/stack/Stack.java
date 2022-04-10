package edu.sda.javaadvanced.collections.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Stack<T> {
    private Deque<T> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public void put(T element) {
        stack.offerLast(element);
    }

    public T take() {
        return stack.pollLast();
    }

    public T peek() {
        return stack.peekLast();
    }
}
