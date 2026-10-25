package LinkedLists;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    // Internal node class to represent data.
    private static class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Empty this linked list, O(n).
    public void clear() {
        Node<T> current = head;
        Node<T> next;

        while (current != null) {
            next = current.next;

            current.prev = current.next = null;
            current.data = null;

            current = next;
        }

        head = tail = null;
        size = 0;
    }

    // Return the size of this linked list.
    public int size() {
        return size;
    }

    // Is this linked list empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // Add an element to the beginning of this linked list, O(1).
    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            head.prev = new Node<>(elem, null, head);
            head = head.prev;
        }

        size++;
    }

    // Add a node to the tail of the linked list, O(1).
    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }

        size++;
    }

    // Check the value of the first node if it exists, O(1).
    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }

        return head.data;
    }

    // Check the value of the last node if it exists, O(1).
    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }

        return tail.data;
    }

    // Remove the first value at the head of the linked list, O(1).
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }

        T data = head.data;

        Node<T> headNext = head.next;

        // Memory clean.
        head.data = null;
        head.next = null;

        head = headNext;
        if (head != null) {
            // Memory clean.
            head.prev = null;
        } else {
            // The linked list is now empty.
            tail = null;
        }

        --size;

        return data;
    }

    // Remove the last value at the tail of the linked list, O(1).
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }

        T data = tail.data;

        Node<T> tailPrev = tail.prev;

        // Memory clean.
        tail.data = null;
        tail.prev = null;

        tail = tailPrev;
        if (tail != null) {
            // Memory clean.
            tail.next = null;
        } else {
            // The linked list is now empty.
            head = null;
        }

        --size;

        return data;
    }

    // Remove an arbitrary node from the linked list, O(1).
    private T remove(Node<T> node) {
        // If th node to remove is somewhere either at the
        // head or the tail handle those independently.
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        // Temporary store the data we want to return.
        T data = node.data;

        // Make the pointers of adjacent nodes skip over 'node'.
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // Memory clean.
        node.prev = node.next = null;
        node.data = null;

        --size;

        // Return the data at the node we just removed.
        return data;
    }

    // Remove a node at particular index, O(n).
    public T removeAt(int index) {
        // Make sure the index provided is valid.
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        Node<T> node;

        if (index < size / 2) {
            // Search from the front of the list.
            node = head;
            for (int i = 0; i != index; i++) {
                node = node.next;
            }
        } else {
            // Search from the back of the list.
            node = tail;
            for (int i = size - 1; i != index; i--) {
                node = node.prev;
            }
        }

        return remove(node);
    }

    // Remove a particular value in the linked list, O(n).
    public boolean remove(Object obj) {
        for (Node<T> node = head; node != null; node = node.next) {
            if ((node.data == null && obj == null) || (node.data != null && node.data.equals(obj))) {
                // Element found.
                remove(node);
                return true;
            }
        }

        // Element not found.
        return false;
    }

    // Find the index of a particular value in the linked list, O(n).
    public int indexOf(Object obj) {
        Node<T> node = head;
        for (int index = 0; node != null; node = node.next, index++) {
            if ((node.data == null && obj == null) || (node.data != null && node.data.equals(obj))) {
                // Element found.
                return index;
            }
        }

        // Element not found.
        return -1;
    }

    // Check if a value is contained within the linked list.
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node<T> current = head; current != null; current = current.next) {
            sb.append(current.data).append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
