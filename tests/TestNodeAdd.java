import org.junit.Assert;
import org.junit.Test;
import edu.iastate.cs228.hw3.StoutList;
import static org.junit.Assert.assertEquals;

public class TestNodeAdd {

    @Test
    public void trivialTest() {
        assertEquals(1, 1);
    }

    @Test
    public void testNodeAdd1() {
        StoutList list = new StoutList();
        if(list.size() != 0) {
            Assert.fail("List should be empty");
        }
        if(!list.add(1)){
            Assert.fail("List should not be able to add");
        }
        if(list.size() != 1) {
            Assert.fail("List should be one");
        }
    }


    @Test
    public void loopTest() {
        StoutList list = new StoutList();
        for(int i = 0; i < 100; i++) {
            if(!list.add(i)) {
                Assert.fail("List should not be able to add the number " + i + " after the number " + (i == 0 ? 0 : i - 1));
            }
        }
        if(list.size() != 100) {
            Assert.fail("List should be empty");
        }
        for(int i = 0; i < 100; i++) {
            if(!list.get(i).equals(i)){
                Assert.fail("List should have the number " + i + " at index " + i);
            }
        }
    }
}
