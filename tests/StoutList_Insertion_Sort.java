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
}
