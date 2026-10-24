package Arrays;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private T[] array;
    private int len = 0;      // Length user thinks array is.
    private int capacity = 0; // Actual array size.

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }

        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index >= len || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }
    public void set(int index, T elem) {
        if (index >= len || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        array[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            array[i] = null;
        }
        len = 0;
    }

    public void add(T elem) {
        if (len + 1 >= capacity) {
            // Time to resize!
            capacity = capacity == 0 ? 1 : 2 * capacity;

            // Create a new array with the new capacity.
            T[] new_array = (T[]) new Object[capacity];

            // Copy values from the old array to the new one.
            for (int i = 0; i < len; i++) {
                new_array[i] = array[i];
            }

            array = new_array;
        }

        array[len++] = elem;
    }

    // Removes the element at the specified index in this list.
    public T removeAt(int rmIndex) {
        if (rmIndex >= len || rmIndex < 0) {
            throw new IndexOutOfBoundsException();
        }

        T data = array[rmIndex];
        for (int i = rmIndex; i < len - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--len] = null;

        return data;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < len; i++) {
            if ((array[i] == null && obj == null) || (array[i] != null && array[i].equals(obj))) {
                // Element found.
                removeAt(i);
                return true;
            }
        }

        // Element not found.
        return false;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if ((array[i] == null && obj == null) || (array[i] != null && array[i].equals(obj))) {
                // Element found.
                return i;
            }
        }

        // Element not found.
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    // Iterator is still fast but not as fast as iterative for loop.
    @Override public java.util.Iterator <T> iterator () {
        return new java.util.Iterator <T> () {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override public String toString() {
        if (len == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder(len);
        sb.append("[");
        for (int i = 0; i < len - 1; i++) {
            sb.append(array[i].toString()).append(", ");
        }
        sb.append(array[len - 1].toString()).append("]");

        return sb.toString();
    }
}
