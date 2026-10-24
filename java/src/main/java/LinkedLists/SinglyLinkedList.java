package LinkedLists;

public class SinglyLinkedList <T> implements Iterable <T> {

    private int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;

    // Internal node class to represent data.
    private class Node <T> {
        T data;
        Node <T> next;

        public Node(T data, Node <T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Empty this linked list, O(n).
    public void clear() {
        Node <T> current = head;
        Node <T> next;

        while (current != null) {
            next = current.next;

            current.next = null;
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
        return  size() == 0;
    }

    // Add an element to the beginning of this linked list, O(1).
    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node <T> (elem, null);
        } else {
            head = new Node <T> (elem, head);
        }

        size++;
    }

    // Add a node to the tail of the linked list, O(1).
    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node <T> (elem, null);
        } else {
            tail.next = new Node <T> (elem, null);
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

        Node <T> headNext = head.next;

        // Memory clean.
        head.data = null;
        head.next = null;

        head = headNext;
        if (head == null) {
            // The linked list is now empty.
            tail = null;
        }

        --size;

        return data;
    }

    // Remove a node at particular index, O(n).
    public T removeAt(int index) {
        // Make sure the index provided is valid.
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        // Check if it's the head.
        if (index == 0) {
            return removeFirst();
        }
        Node <T> current = head;
        for (int i = 0; i + 1 != index; i++) {
            current = current.next;
        }

        Node <T> nextNode = current.next;
        T data = nextNode.data;
        if (nextNode == tail) tail = current;

        current.next = nextNode.next;

        // Memory clean.
        nextNode.data = null;
        nextNode.next = null;

        --size;

        return data;
    }

    // Remove the last value at the tail of the linked list, O(n).
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }

        return removeAt(size - 1);
    }

    // Remove a particular value in the linked list, O(n).
    public boolean remove(Object obj) {
        // Check if it's the head.
        if ((head.data == null && obj == null) || (head.data != null && head.data.equals(obj))) {
            removeFirst();
            return true;
        }

        Node <T> nextNode;
        for (Node <T> current = head; current.next != null; current = current.next) {
            nextNode = current.next;
            if ((nextNode.data == null && obj == null) || (nextNode.data != null && nextNode.data.equals(obj))) {
                // Element found.
                current.next = nextNode.next;

                if (nextNode == tail) tail = current;

                // Memory clean.
                nextNode.data = null;
                nextNode.next = null;

                --size;

                return true;
            }
        }

        // Element not found.
        return false;
    }

    // Find the index of a particular value in the linked list, O(n).
    public int indexOf(Object obj) {
        Node <T> node = head;
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

    @Override public java.util.Iterator <T> iterator () {
        return new java.util.Iterator <T> () {
            private Node <T> current = head;

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

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node <T> current = head; current != null; current = current.next) {
            sb.append(current.data).append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
