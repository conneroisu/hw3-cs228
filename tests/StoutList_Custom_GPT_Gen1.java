import edu.iastate.cs228.hw3.StoutList;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class StoutList_Custom_GPT_Gen1 {


    StoutList<Integer> list;

    @Before
    public void setUp() {
        list = new StoutList<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void testAddIndex() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(1, 3);
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexOutOfBounds() {
        list.add(0, 1);
        list.add(3, 2);
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexOutOfBounds() {
        list.add(1);
        list.remove(5);
    }

    @Test
    public void testSort() {
        list.add(3);
        list.add(1);
        list.add(2);
        list.sort();
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void testSortReverse() {
        list.add(1);
        list.add(3);
        list.add(2);
        list.sortReverse();
        assertEquals(Integer.valueOf(3), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(1), list.get(2));
    }

    @Test
    public void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testListIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        ListIterator<Integer> iterator = list.listIterator();
        assertTrue(iterator.hasNext());
        assertFalse(iterator.hasPrevious());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertTrue(iterator.hasPrevious());
        assertEquals(Integer.valueOf(1), iterator.previous());
        assertEquals(Integer.valueOf(1), iterator.next());
        iterator.add(4);
        assertEquals(Integer.valueOf(4), list.get(1));
    }

    @Test
    public void testAddgpt() {
        StoutList<Integer> list = new StoutList<>();
        assertTrue(list.add(1));
        assertEquals(1, list.size());
        assertTrue(list.add(2));
        assertEquals(2, list.size());
    }

    @Test
    public void testSortgptgptReverse() {
        StoutList<Integer> list = new StoutList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.sortReverse();
        assertEquals((Integer) 3, list.get(0));
        assertEquals((Integer) 2, list.get(1));
        assertEquals((Integer) 1, list.get(2));
    }


    @Test
    public void testgptSortgpt() {
        StoutList<Integer> list = new StoutList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.sort();
        assertEquals((Integer) 1, list.get(0));
        assertEquals((Integer) 2, list.get(1));
        assertEquals((Integer) 3, list.get(2));
    }

    @Test
    public void testgptAddPosition() {
        StoutList<Integer> list = new StoutList<>();
        list.add(0, 1);
        assertEquals(1, list.size());
        list.add(1, 2);
        assertEquals(2, list.size());
    }


    @Test
    public void testgptRemove() {
        StoutList<Integer> list = new StoutList<>();
        list.add(1);
        list.add(2);
        assertEquals(Integer.valueOf(1), list.remove(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testgptSort() {
        StoutList<Integer> list = new StoutList<>();
        list.add(2);
        list.add(1);
        list.sort();
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
    }

    @Test
    public void testSortgptReverse() {
        StoutList<Integer> list = new StoutList<>();
        list.add(1);
        list.add(2);
        list.sortReverse();
        assertEquals(Integer.valueOf(2), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
    }

    @Test
    public void testgptIterator() {
        StoutList<Integer> list = new StoutList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testgptListIterator() {
        StoutList<Integer> list = new StoutList<>();
        list.add(1);
        list.add(2);
        ListIterator<Integer> iterator = list.listIterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testClear() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContains() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertFalse(list.contains(4));
    }

    @Test
    public void testIndexOf() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(3));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    public void testLastIndexOf() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);
        assertEquals(2, list.lastIndexOf(1));
        assertEquals(4, list.lastIndexOf(2));
        assertEquals(3, list.lastIndexOf(3));
        assertEquals(-1, list.lastIndexOf(4));
    }

    @Test
    public void testgptListIteratorIndex() {
        StoutList<Integer> list = new StoutList<>();
        list.add(1);
        list.add(2);
        ListIterator<Integer> iterator = list.listIterator(1);
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertFalse(iterator.hasNext());
    }

}