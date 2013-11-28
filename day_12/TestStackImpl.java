import org.junit.*;
import static org.junit.Assert.*;

public class TestStackImpl {
    private Stack<Integer> si;

    @Before
    public void setup() {
	si = new StackImpl<Integer>();
    }

    @Test
    public void TestShouldAdddToStack() {
	Integer expected = 1;
	si.push(expected);
	assertEquals(expected, si.peek());
    }
}
