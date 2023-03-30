import org.junit.Assert;
import org.junit.Test;
import edu.iastate.cs228.hw3.StoutList;
public class TestStoutListAdd {
    @Test
    public void trivialTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void nullItemTest() {
        StoutList<Integer> list = new StoutList<Integer>();
        // adding a null element should throw a NullPointerException
        try {
            list.add(null);
        } catch (NullPointerException e) {
            // expected
            Assert.assertTrue(true);
            return;
        }
        Assert.fail("Expected a NullPointerException");
    }
    @Test
    public void nullItemTestTwoArguments() {
        StoutList<Integer> list = new StoutList<Integer>();
        // adding a null element should throw a NullPointerException
        try {
            list.add(0, null);
        } catch (NullPointerException e) {
            // expected
            Assert.assertTrue(true);
            return;
        }
        Assert.fail("Expected a NullPointerException");
    }
}
