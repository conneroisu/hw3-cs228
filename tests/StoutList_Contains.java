import org.junit.Test;
import edu.iastate.cs228.hw3.StoutList;

import static org.junit.Assert.assertEquals;
public class StoutList_Contains {

    @Test
    public void trivialTest() { assertEquals(1, 1); }

    @Test
    public void contains1() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        assertEquals(true, list.contains(4));
    }

    @Test
    public void contains2() {
        StoutList list = new StoutList(4);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        assertEquals(false, list.contains(5));
    }

    @Test
    public void contains3() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        assertEquals(true, list.contains(9));
    }

    @Test
    public void contains4() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        assertEquals(false, list.contains(0));
    }

    @Test
    public void contains5() {
        StoutList list = new StoutList();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        assertEquals(true, list.contains(1));
    }

    @Test
    public void contains6() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        assertEquals(true, list.contains(2));
    }

    @Test
    public void contains7() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        assertEquals(true, list.contains(3));
    }

    @Test
    public void contains8() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        assertEquals(true, list.contains(4));
    }

    @Test
    public void contains9() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        assertEquals(true, list.contains(10));
    }

    @Test
    public void contains10() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        assertEquals(true, list.contains(11));
    }

    @Test
    public void contains11() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        assertEquals(true, list.contains(11));
    }


}
