import org.junit.*;
import static org.junit.Assert.*;

public class TestStack {
    private Stack<Integer> s;

    // @Test(expected = Exception.class)
    // public void testShouldOnlyAllowToBeOfTypeNumber() {
    //     Stack<String> s = new StackImpl<>();
    // }

    @Before
    public void setup() {
        s = new StackImpl<>();
    }

    @Test
    public void testShouldPushOntoStack() {
        Integer expected = 1;

        s.push(expected);
        assertEquals(expected, s.pop());
    }

    @Test
    public void testShouldReturnTheFirstPushOnTheLastPop() {
        Integer expected = 2;

        s.push(expected);
        s.push(1);
        s.push(4);

        s.pop();
        s.pop();

        assertEquals(expected, s.pop());
        assertEquals(true, s.isEmpty());
    }

    @Test
    public void testShouldKnowIfStackIsEmpty() {
        assertEquals(true, s.isEmpty());
        s.push(1);
        assertEquals(false, s.isEmpty());
    }

    @Test
    public void testShouldReturnNullIfNothingOnTheStackToPop() {
        assertEquals(null, s.pop());

        Integer expected = 2;
        s.push(expected);
        assertEquals(expected, s.pop());

        assertEquals(null, s.pop());
    }
}
