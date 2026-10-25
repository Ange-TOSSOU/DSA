package Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListBasedQueueTest {

    LinkedListBasedQueue<Integer> queue;

    @BeforeEach
    public void setup() {
        queue = new LinkedListBasedQueue<>();
    }

    @Test
    public void testEmptyQueue() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testPollOnEmpty() {
        assertThrows(RuntimeException.class, () -> queue.poll());
    }

    @Test
    public void testPeekOnEmpty() {
        assertThrows(RuntimeException.class, () -> queue.peek());
    }

    @Test
    public void testOffer() {
        queue.enqueue(2);
        assertEquals(1, queue.size());
    }

    @Test
    public void testPeek() {
        queue.enqueue(2);
        assertEquals(2, (int) queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    public void testPoll() {
        queue.enqueue(2);
        assertEquals(2, (int) queue.poll());
        assertEquals(0, queue.size());
    }

    @Test
    public void testExhaustively() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        queue.enqueue(2);
        assertEquals(2, queue.size());
        assertEquals(1, (int) queue.peek());
        assertEquals(2, queue.size());
        assertEquals(1, (int) queue.poll());
        assertEquals(1, queue.size());
        assertEquals(2, (int) queue.peek());
        assertEquals(1, queue.size());
        assertEquals(2, (int) queue.poll());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }
}