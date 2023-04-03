import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import edu.iastate.cs228.hw3.StoutList;

public class StoutList_Documented_Sequence {
    // Stout List for Class
    private StoutList<String> list;
    @Before
    public void documentSetup() {
        list = new StoutList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

    }

    @Test
    public void trivialTest() {
        Assert.assertTrue(true);
    }


    @Test
    public void testAdd() {
        // after add "V", the list should be "A", "B", "C", "D", "E", "V"
        list.add("V");
        Assert.assertEquals("B", list.get(1));
        Assert.assertEquals("C", list.get(2));
        Assert.assertEquals("D", list.get(3));
        Assert.assertEquals("E", list.get(4));
        Assert.assertEquals("V", list.get(5));
    }
}
