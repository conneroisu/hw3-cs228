import org.junit.Assert;
import org.junit.Test;

import edu.iastate.cs228.hw3.StoutList;
public class StoutList_Bubble_Sort {
    /**
     * Trivial test to make sure JUnit is working.
     */
    @Test
    public void trivialTest() {
        Assert.assertTrue(true);
    }


    /**
     * Test the bubble sort method on a StoutList of 4 elements. Reverse sort should result in the list being sorted in non-ascending order.
     */
    @Test
    public void testBubbleSort4() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.sortReverse();
        Assert.assertEquals(4, list.get(0).intValue());
        Assert.assertEquals(3, list.get(1).intValue());
        Assert.assertEquals(2, list.get(2).intValue());
        Assert.assertEquals(1, list.get(3).intValue());
    }

    /**
     * Test the bubble sort method on a StoutList of 5 elements. Reverse sort should result in the list being sorted in non-ascending order.
     */
    @Test
    public void testBubbleSort5() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.sortReverse();
        Assert.assertEquals(5, list.get(0).intValue());
        Assert.assertEquals(4, list.get(1).intValue());
        Assert.assertEquals(3, list.get(2).intValue());
        Assert.assertEquals(2, list.get(3).intValue());
        Assert.assertEquals(1, list.get(4).intValue());
    }

    /**
     * Test the bubble sort method on a StoutList of 6 elements. Reverse sort should result in the list being sorted in non-ascending order.
     */
    @Test
    public void testBubbleSort6() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.sortReverse();
        Assert.assertEquals(6, list.get(0).intValue());
        Assert.assertEquals(5, list.get(1).intValue());
        Assert.assertEquals(4, list.get(2).intValue());
        Assert.assertEquals(3, list.get(3).intValue());
        Assert.assertEquals(2, list.get(4).intValue());
        Assert.assertEquals(1, list.get(5).intValue());
    }

    /**
     * Test the bubble sort method on a StoutList of 7 elements. Reverse sort should result in the list being sorted in non-ascending order.
     */
    @Test
    public void testBubbleSort7() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.sortReverse();
        Assert.assertEquals(7, list.get(0).intValue());
        Assert.assertEquals(6, list.get(1).intValue());
        Assert.assertEquals(5, list.get(2).intValue());
        Assert.assertEquals(4, list.get(3).intValue());
        Assert.assertEquals(3, list.get(4).intValue());
        Assert.assertEquals(2, list.get(5).intValue());
        Assert.assertEquals(1, list.get(6).intValue());
    }

    /**
     * Test the bubble sort method on a StoutList of 8 elements. Reverse sort should result in the list being sorted in non-ascending order.
     */
    @Test
    public void testBubbleSort8() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.sortReverse();
        Assert.assertEquals(8, list.get(0).intValue());
        Assert.assertEquals(7, list.get(1).intValue());
        Assert.assertEquals(6, list.get(2).intValue());
        Assert.assertEquals(5, list.get(3).intValue());
        Assert.assertEquals(4, list.get(4).intValue());
        Assert.assertEquals(3, list.get(5).intValue());
        Assert.assertEquals(2, list.get(6).intValue());
        Assert.assertEquals(1, list.get(7).intValue());
    }

    /**
     * Test the bubble sort method on a StoutList of 9 elements. Reverse sort should result in the list being sorted in non-ascending order.
     */
    @Test
    public void testBubbleSort9() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.sortReverse();
        Assert.assertEquals(9, list.get(0).intValue());
        Assert.assertEquals(8, list.get(1).intValue());
        Assert.assertEquals(7, list.get(2).intValue());
        Assert.assertEquals(6, list.get(3).intValue());
        Assert.assertEquals(5, list.get(4).intValue());
        Assert.assertEquals(4, list.get(5).intValue());
        Assert.assertEquals(3, list.get(6).intValue());
        Assert.assertEquals(2, list.get(7).intValue());
        Assert.assertEquals(1, list.get(8).intValue());
    }

    /**
     * Test the bubble sort method on a StoutList of 10 elements. Reverse sort should result in the list being sorted in non-ascending order.
     */
    @Test
    public void testBubbleSort10() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.sortReverse();
        Assert.assertEquals(10, list.get(0).intValue());
        Assert.assertEquals(9, list.get(1).intValue());
        Assert.assertEquals(8, list.get(2).intValue());
        Assert.assertEquals(7, list.get(3).intValue());
        Assert.assertEquals(6, list.get(4).intValue());
        Assert.assertEquals(5, list.get(5).intValue());
        Assert.assertEquals(4, list.get(6).intValue());
        Assert.assertEquals(3, list.get(7).intValue());
        Assert.assertEquals(2, list.get(8).intValue());
        Assert.assertEquals(1, list.get(9).intValue());
    }

    /**
     * Test the bubble sort method on a StoutList of 11 elements. Reverse sort should result in the list being sorted in non-ascending order.
     */
    @Test
    public void testBubbleSort11() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(11);
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.sortReverse();
        Assert.assertEquals(11, list.get(0).intValue());
        Assert.assertEquals(10, list.get(1).intValue());
        Assert.assertEquals(9, list.get(2).intValue());
        Assert.assertEquals(8, list.get(3).intValue());
        Assert.assertEquals(7, list.get(4).intValue());
        Assert.assertEquals(6, list.get(5).intValue());
        Assert.assertEquals(5, list.get(6).intValue());
        Assert.assertEquals(4, list.get(7).intValue());
        Assert.assertEquals(3, list.get(8).intValue());
        Assert.assertEquals(2, list.get(9).intValue());
        Assert.assertEquals(1, list.get(10).intValue());
    }

    /**
     * Test the bubble sort method on a StoutList of 12 elements. Reverse sort should result in the list being sorted in non-ascending order.
     */
    @Test
    public void testBubbleSort12() {
        StoutList<Integer> list = new StoutList<Integer>();
        list.add(12);
        list.add(11);
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.sortReverse();
        Assert.assertEquals(12, list.get(0).intValue());
        Assert.assertEquals(11, list.get(1).intValue());
        Assert.assertEquals(10, list.get(2).intValue());
        Assert.assertEquals(9, list.get(3).intValue());
        Assert.assertEquals(8, list.get(4).intValue());
        Assert.assertEquals(7, list.get(5).intValue());
        Assert.assertEquals(6, list.get(6).intValue());
        Assert.assertEquals(5, list.get(7).intValue());
        Assert.assertEquals(4, list.get(8).intValue());
        Assert.assertEquals(3, list.get(9).intValue());
        Assert.assertEquals(2, list.get(10).intValue());
        Assert.assertEquals(1, list.get(11).intValue());
    }


}
