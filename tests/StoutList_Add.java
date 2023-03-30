import edu.iastate.cs228.hw3.StoutList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoutList_Add {
    @Test
    public void trivial_test() {
        Assert.assertTrue(true);
    }

    @Test
    public void testStoutListConstruction0ZeroSize() {
        StoutList<Integer> sl = new StoutList<>();
        assertEquals(0, sl.size());
    }


    @Test
    public void testStoutListConstruction1AddOne() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        assertEquals(1, sl.size());
    }

    @Test
    public void testStoutListConstruction2AddTwo() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        assertEquals(2, sl.size());
        assertEquals(1, sl.get(0).intValue());
    }

    @Test
    public void testStoutListConstruction3AddThree() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        assertEquals(1, sl.get(0).intValue());
        assertEquals(2, sl.get(1).intValue());
        assertEquals(3, sl.get(2).intValue());
    }

    @Test
    public void testStoutListConstruction4AddFour() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        assertEquals(4, sl.size());
        assertEquals(1, sl.get(0).intValue());
        assertEquals(2, sl.get(1).intValue());
        assertEquals(3, sl.get(2).intValue());
        assertEquals(4, sl.get(3).intValue());
    }

    @Test
    public void testStoutListConstruction5AddFive() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        assertEquals(5, sl.size());
    }

    @Test
    public void testStoutListConstruction6AddSix() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        assertEquals(6, sl.size());
    }

    @Test
    public void testStoutListConstruction7AddSeven() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        assertEquals(7, sl.size());
    }

    @Test
    public void testStoutListConstruction8AddEight() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        assertEquals(8, sl.size());
        // check that the first 8 elements are correct
        for (int i = 0; i < 8; i++) {
            assertEquals(i + 1, sl.get(i).intValue());
        }
    }

    @Test
    public void testStoutListConstruction9AddNine() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        assertEquals(9, sl.size());
    }

    @Test
    public void testStoutListConstruction10AddTen() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        assertEquals(10, sl.size());
    }

    @Test
    public void testStoutListConstruction11AddEleven() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        assertEquals(11, sl.size());
    }

    @Test
    public void testStoutListConstruction12AddTwelve() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        assertEquals(12, sl.size());
    }

    @Test
    public void testStoutListConstruction13AddThirteen() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        assertEquals(13, sl.size());
    }

    @Test
    public void testStoutListConstruction14AddFourteen() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        assertEquals(14, sl.size());
    }

    @Test
    public void testStoutListConstruction15AddFifteen() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        assertEquals(15, sl.size());
    }

    @Test
    public void testStoutListConstruction16AddSixteen() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        assertEquals(16, sl.size());
    }

    @Test
    public void testStoutListConstruction17AddSeventeen() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        assertEquals(17, sl.size());
    }

    @Test
    public void testStoutListConstruction18AddEighteen() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        assertEquals(18, sl.size());
    }

    @Test
    public void testStoutListConstruction19AddNineteen() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        assertEquals(19, sl.size());
    }

    @Test
    public void testStoutListConstruction20AddTwenty() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        sl.add(20);
        assertEquals(20, sl.size());
    }

    @Test
    public void testStoutListConstruction21AddTwentyOne() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        sl.add(20);
        sl.add(21);
        assertEquals(21, sl.size());
    }

    @Test
    public void testStoutListConstruction22AddTwentyTwo() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        sl.add(20);
        sl.add(21);
        sl.add(22);
        assertEquals(22, sl.size());
    }

    @Test
    public void testStoutListConstruction23AddTwentyThree() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        sl.add(20);
        sl.add(21);
        sl.add(22);
        sl.add(23);
        assertEquals(23, sl.size());
    }

    @Test
    public void testStoutListConstruction24AddTwentyFour() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        sl.add(20);
        sl.add(21);
        sl.add(22);
        sl.add(23);
        sl.add(24);
        assertEquals(24, sl.size());
    }

    @Test
    public void testStoutListConstruction25AddTwentyFive() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        sl.add(20);
        sl.add(21);
        sl.add(22);
        sl.add(23);
        sl.add(24);
        sl.add(25);
        assertEquals(25, sl.size());
    }

    @Test
    public void testStoutListConstruction26AddTwentySix() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        sl.add(20);
        sl.add(21);
        sl.add(22);
        sl.add(23);
        sl.add(24);
        sl.add(25);
        sl.add(26);
        assertEquals(26, sl.size());
    }

    @Test
    public void testStoutListConstruction27AddTwentySeven() {
        StoutList<Integer> sl = new StoutList<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        sl.add(20);
        sl.add(21);
        sl.add(22);
        sl.add(23);
        sl.add(24);
        sl.add(25);
        sl.add(26);
        sl.add(27);
        assertEquals(27, sl.size());
    }

    @Test
    public void testStoutListConstruction28AddTwentyEight() {
        StoutList sl = new StoutList(4);
        for(int i = 1; i <= 28; i++)
            if(!sl.add(i)){
                fail("Failed to add " + i);
            }
        assertEquals(28, sl.size());
    }

    @Test
    public void testStoutListConstruction29AddTwentyNine() {
        StoutList<Integer> sl = new StoutList<Integer>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        sl.add(20);
        sl.add(21);
        sl.add(22);
        sl.add(23);
        sl.add(24);
        sl.add(25);
        sl.add(26);
        sl.add(27);
        sl.add(28);
        sl.add(29);
        assertEquals(29, sl.size());
    }

    @Test
    public void testStoutListConstruction30AddThirty() {
        StoutList<Integer> sl = new StoutList<Integer>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        sl.add(20);
        sl.add(21);
        sl.add(22);
        sl.add(23);
        sl.add(24);
        sl.add(25);
        sl.add(26);
        sl.add(27);
        sl.add(28);
        sl.add(29);
        sl.add(30);
        assertEquals(30, sl.size());
    }

    @Test
    public void loopingAdd1() {
        // create a new StoutList
        StoutList<Integer> sl = new StoutList<Integer>();
        // add 100 elements to the StoutList
        for (int i = 0; i < 100; i++) {
            sl.add(i);
        }
        // check that the size is 100
        assertEquals(100, sl.size());
        // check that the elements are in the correct positions
        for (int i = 0; i < 100; i++) {
            assertEquals(i, sl.get(i).intValue());
        }
    }

    @Test
    public void loopingAdd2() {
        // create a new StoutList
        StoutList<Integer> sl = new StoutList<Integer>();
        // add 100 elements to the StoutList in reverse order
        for (int i = 99; i >= 0; i--) {
            sl.add(i);
        }
        // check that the size is 100
        assertEquals(100, sl.size());
        // check that the elements are in the correct positions
        for (int i = 99; i >= 0; i--) {
            assertEquals(i, sl.get(99 - i).intValue());
        }
    }

    @Test
    public void addingthousand() {
        StoutList<Integer> sl = new StoutList<Integer>();
        for (int i = 0; i < 1000; i++) {
            sl.add(i);
        }
        assertEquals(1000, sl.size());
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, sl.get(i).intValue());
        }
    }

    @Test
    public void randomAddthousand() {
        StoutList<Integer> sl = new StoutList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            sl.add(r.nextInt());
        }
        assertEquals(1000, sl.size());
    }

    @Test
    public void randomAddHundred () {
        StoutList<Integer> sl = new StoutList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            sl.add(r.nextInt());
        }
        assertEquals(100, sl.size());
    }

    @Test
    public void randomAddTen () {
        StoutList<Integer> sl = new StoutList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            sl.add(r.nextInt());
        }
        assertEquals(10, sl.size());
    }

    @Test
    public void randomAddOne () {
        StoutList<Integer> sl = new StoutList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 1; i++) {
            sl.add(r.nextInt());
        }
        assertEquals(1, sl.size());
    }
}
