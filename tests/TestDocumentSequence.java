import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import edu.iastate.cs228.hw3.StoutList;

public class TestDocumentSequence {
    StoutList list;
    @Before
    public void documentSetup() {
        list = new StoutList<String>();
        list.set(0, "A");
        list.set(1, "B");
        list.set(2, "C");
        list.set(3, "D");
        list.set(4, "E");
    }

    @Test
    public void trivialTest() {
        Assert.assertTrue(true);
    }


    @Test
    public void testAdd() {
        // after add "V", the list should be "A", "B", "C", "D", "E", "V"
        list.add("V");
        Assert.assertEquals("A", list.get(0));
        Assert.assertEquals("B", list.get(1));
        Assert.assertEquals("C", list.get(2));
        Assert.assertEquals("D", list.get(3));
        Assert.assertEquals("E", list.get(4));
        Assert.assertEquals("V", list.get(5));
    }
}
