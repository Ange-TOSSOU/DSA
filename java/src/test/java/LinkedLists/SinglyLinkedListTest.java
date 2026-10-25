package LinkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SinglyLinkedListTest {

    static final int LOOPS = 10000;
    static final int TEST_SZ = 40;
    static final int NUM_NULLS = TEST_SZ / 5;
    static final int MAX_RAND_NUM = 250;

    SinglyLinkedList<Integer> list;

    @BeforeEach
    public void beforeTest() {
        list = new SinglyLinkedList<>();
    }

    @Test
    public void testEmptyList() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveFirstOfEmpty() {
        assertThrows(RuntimeException.class, () -> list.removeFirst());
    }

    @Test
    public void testRemoveLastOfEmpty() {
        assertThrows(RuntimeException.class, () -> list.removeLast());
    }

    @Test
    public void testPeekFirstOfEmpty() {
        assertThrows(RuntimeException.class, () -> list.peekFirst());
    }

    @Test
    public void testPeekLastOfEmpty() {
        assertThrows(RuntimeException.class, () -> list.peekLast());
    }

    @Test
    public void testAddFirst() {
        list.addFirst(3);
        assertEquals(1, list.size());
        list.addFirst(5);
        assertEquals(2, list.size());
    }

    @Test
    public void testAddLast() {
        list.addLast(3);
        assertEquals(1, list.size());
        list.addLast(5);
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveFirst() {
        list.addFirst(3);
        assertEquals(3, (int) list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveLast() {
        list.addLast(4);
        assertEquals(4, (int) list.removeLast());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testPeekFirst() {
        list.addFirst(4);
        assertEquals(4, (int) list.peekFirst());
        assertEquals(1, list.size());
    }

    @Test
    public void testPeekLast() {
        list.addLast(4);
        assertEquals(4, (int) list.peekLast());
        assertEquals(1, list.size());
    }

    @Test
    public void testPeeking() {

        // 5
        list.addFirst(5);
        assertEquals(5, (int) list.peekFirst());
        assertEquals(5, (int) list.peekLast());

        // 6 - 5
        list.addFirst(6);
        assertEquals(6, (int) list.peekFirst());
        assertEquals(5, (int) list.peekLast());

        // 7 - 6 - 5
        list.addFirst(7);
        assertEquals(7, (int) list.peekFirst());
        assertEquals(5, (int) list.peekLast());

        // 7 - 6 - 5 - 8
        list.addLast(8);
        assertEquals(7, (int) list.peekFirst());
        assertEquals(8, (int) list.peekLast());

        // 7 - 6 - 5
        list.removeLast();
        assertEquals(7, (int) list.peekFirst());
        assertEquals(5, (int) list.peekLast());

        // 7 - 6
        list.removeLast();
        assertEquals(7, (int) list.peekFirst());
        assertEquals(6, (int) list.peekLast());

        // 6
        list.removeFirst();
        assertEquals(6, (int) list.peekFirst());
        assertEquals(6, (int) list.peekLast());
    }

    @Test
    public void testRemoving() {

        DoublyLinkedList<String> strs = new DoublyLinkedList<>();
        strs.addLast("a");
        strs.addLast("b");
        strs.addLast("c");
        strs.addLast("d");
        strs.addLast("e");
        strs.addLast("f");
        strs.remove("b");
        strs.remove("a");
        strs.remove("d");
        strs.remove("e");
        strs.remove("c");
        strs.remove("f");
        assertEquals(0, strs.size());
    }

    @Test
    public void testRemoveAt() {

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.removeAt(0);
        list.removeAt(2);
        assertEquals(2, (int) list.peekFirst());
        assertEquals(3, (int) list.peekLast());
        list.removeAt(1);
        list.removeAt(0);
        assertEquals(0, list.size());
    }

    @Test
    public void testClear() {

        list.addLast(22);
        list.addLast(33);
        list.addLast(44);
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
        list.addLast(22);
        list.addLast(33);
        list.addLast(44);
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testRandomizedRemoving() {

        LinkedList<Integer> LIST = new LinkedList<>();
        for (int loops = 0; loops < LOOPS; loops++) {

            list.clear();
            LIST.clear();

            List<Integer> randNums = genRandList();
            for (Integer value : randNums) {
                LIST.addLast(value);
                list.addLast(value);
            }

            Collections.shuffle(randNums);

            for (Integer rm_val : randNums) {

                assertEquals(LIST.remove(rm_val), list.remove(rm_val));
                assertEquals(LIST.size(), list.size());

                Iterator<Integer> iter1 = LIST.iterator();
                Iterator<Integer> iter2 = list.iterator();
                while (iter1.hasNext()) assertEquals(iter1.next(), iter2.next());

                iter1 = LIST.iterator();
                iter2 = list.iterator();
                while (iter1.hasNext()) assertEquals(iter1.next(), iter2.next());
            }

            list.clear();
            LIST.clear();

            for (Integer value : randNums) {
                LIST.addLast(value);
                list.addLast(value);
            }

            // Try removing elements whether they exist
            for (int i = 0; i < randNums.size(); i++) {

                Integer rm_val = (int) (MAX_RAND_NUM * Math.random());
                assertEquals(LIST.remove(rm_val), list.remove(rm_val));
                assertEquals(LIST.size(), list.size());

                Iterator<Integer> iter1 = LIST.iterator();
                Iterator<Integer> iter2 = list.iterator();
                while (iter1.hasNext()) assertEquals(iter1.next(), iter2.next());
            }
        }
    }

    @Test
    public void testRandomizedRemoveAt() {

        LinkedList<Integer> LIST = new LinkedList<>();

        for (int loops = 0; loops < LOOPS; loops++) {

            list.clear();
            LIST.clear();

            List<Integer> randNums = genRandList();

            for (Integer value : randNums) {
                LIST.addLast(value);
                list.addLast(value);
            }

            for (int i = 0; i < randNums.size(); i++) {

                int rm_index = (int) (list.size() * Math.random());

                Integer num1 = LIST.remove(rm_index);
                Integer num2 = list.removeAt(rm_index);
                assertEquals(num1, num2);
                assertEquals(LIST.size(), list.size());

                Iterator<Integer> iter1 = LIST.iterator();
                Iterator<Integer> iter2 = list.iterator();
                while (iter1.hasNext()) assertEquals(iter1.next(), iter2.next());
            }
        }
    }

    @Test
    public void testRandomizedIndexOf() {

        LinkedList<Integer> LIST = new LinkedList<>();

        for (int loops = 0; loops < LOOPS; loops++) {

            LIST.clear();
            list.clear();

            List<Integer> randNums = genUniqueRandList();

            for (Integer value : randNums) {
                LIST.addLast(value);
                list.addLast(value);
            }

            Collections.shuffle(randNums);

            for (Integer elem : randNums) {

                Integer index1 = LIST.indexOf(elem);
                Integer index2 = list.indexOf(elem);

                assertEquals(index1, index2);
                assertEquals(LIST.size(), list.size());

                Iterator<Integer> iter1 = LIST.iterator();
                Iterator<Integer> iter2 = list.iterator();
                while (iter1.hasNext()) assertEquals(iter1.next(), iter2.next());
            }
        }
    }

    // Generate a list of random numbers
    static List<Integer> genRandList() {
        List<Integer> lst = new ArrayList<>(SinglyLinkedListTest.TEST_SZ);
        for (int i = 0; i < SinglyLinkedListTest.TEST_SZ; i++) lst.add((int) (Math.random() * MAX_RAND_NUM));
        for (int i = 0; i < NUM_NULLS; i++) lst.add(null);
        Collections.shuffle(lst);
        return lst;
    }

    // Generate a list of unique random numbers
    static List<Integer> genUniqueRandList() {
        List<Integer> lst = new ArrayList<>(SinglyLinkedListTest.TEST_SZ);
        for (int i = 0; i < SinglyLinkedListTest.TEST_SZ; i++) lst.add(i);
        for (int i = 0; i < NUM_NULLS; i++) lst.add(null);
        Collections.shuffle(lst);
        return lst;
    }
}