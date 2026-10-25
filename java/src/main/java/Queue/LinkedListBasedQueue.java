package Queue;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListBasedQueue<T> implements Iterable<T> {

    private final LinkedList<T> list = new LinkedList<>();

    // Create an empty queue.
    public LinkedListBasedQueue() {
    }

    // Create a Queue with an initial element.
    public LinkedListBasedQueue(T firstElem) {
        enqueue(firstElem);
    }

    // Return the size of the queue.
    public int size() {
        return list.size();
    }

    // Check whether the queue is empty.
    public boolean isEmpty() {
        return size() == 0;
    }

    // Peek the element at the front of the queue.
    // The method throws an error if the queue is empty.
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Empty");
        }

        return list.peekFirst();
    }

    // Poll an element from the front of the queue.
    // The method throws an error if the queue is empty.
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Empty");
        }

        return list.removeFirst();
    }

    // Add an element on the back of the queue.
    public void enqueue(T elem) {
        list.addLast(elem);
    }

    // Return an iterator to allow the user to traverse
    // through the elements found inside the queue.
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}

