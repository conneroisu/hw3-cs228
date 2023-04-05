import org.junit.Test;

import edu.iastate.cs228.hw3.StoutList;
import static org.junit.Assert.assertEquals;

public class StoutList_Insertion_Sort {
    
    @Test
    public void trivialTest() { assertEquals(1, 1); }
    
    @Test
    public void InsertSort4() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
    }

    @Test
    public void InsertSort5() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
    }

    @Test
    public void InsertSort6() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
    }

    @Test
    public void InsertSort7() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
    }

    @Test
    public void InsertSort8() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
    }

    @Test
    public void InsertSort9() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(10);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
        assertEquals(9, (int) list.get(8));
    }

    @Test
    public void InsertSort10() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(10);
        list.add(11);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
        assertEquals(9, (int) list.get(8));
        assertEquals(10, (int) list.get(9));
    }

    @Test
    public void InsertSort11() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(10);
        list.add(11);
        list.add(12);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
        assertEquals(9, (int) list.get(8));
        assertEquals(10, (int) list.get(9));
        assertEquals(11, (int) list.get(10));
    }

    @Test
    public void InsertSort12() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
        assertEquals(9, (int) list.get(8));
        assertEquals(10, (int) list.get(9));
        assertEquals(11, (int) list.get(10));
        assertEquals(12, (int) list.get(11));
    }

    @Test
    public void InsertSort13() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
        assertEquals(9, (int) list.get(8));
        assertEquals(10, (int) list.get(9));
        assertEquals(11, (int) list.get(10));
        assertEquals(12, (int) list.get(11));
        assertEquals(13, (int) list.get(12));
    }

    @Test
    public void InsertSort14() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
        assertEquals(9, (int) list.get(8));
        assertEquals(10, (int) list.get(9));
        assertEquals(11, (int) list.get(10));
        assertEquals(12, (int) list.get(11));
        assertEquals(13, (int) list.get(12));
        assertEquals(14, (int) list.get(13));
    }

    @Test
    public void InsertSort15() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.sort();
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
        assertEquals(9, (int) list.get(8));
        assertEquals(10, (int) list.get(9));
        assertEquals(11, (int) list.get(10));
        assertEquals(12, (int) list.get(11));
        assertEquals(13, (int) list.get(12));
        assertEquals(14, (int) list.get(13));
        assertEquals(15, (int) list.get(14));
    }
}
