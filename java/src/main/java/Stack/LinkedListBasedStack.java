package Stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListBasedStack<T> implements Iterable<T> {

    private final LinkedList<T> list = new LinkedList<>();

    // Create an empty stack.
    public LinkedListBasedStack() {
    }

    // Create a Stack with an initial element.
    public LinkedListBasedStack(T firstElem) {
        push(firstElem);
    }

    // Return the number of elements in the stack.
    public int size() {
        return list.size();
    }

    // Check if the stack is empty.
    public boolean isEmpty() {
        return size() == 0;
    }

    // Push an element on the stack.
    public void push(T elem) {
        list.addFirst(elem);
    }

    // Pop an element off the stack.
    // Throws an error if the stack is empty.
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return list.removeFirst();
    }

    // Peek the top of the stack without removing an element.
    // Throws an error if the stack is empty.
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return list.peekFirst();
    }

    // Allow users to iterate through the stack using an iterator.
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
