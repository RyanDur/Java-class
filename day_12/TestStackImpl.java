import org.junit.*;
import static org.junit.Assert.*;

public class TestStackImpl {
    private Stack<Integer> si;

    @Before
    public void setup() {
	si = new StackImpl<Integer>();
	si.push(1);
    }

    @Test
    public void TestShouldAdddToStack() {
	Integer expected = 1;
	assertEquals(expected, si.peek());
    }

    @Test
    public void TestShouldAddToTopOfStack() {
	Integer expected = 2;
	si.push(expected);
	assertEquals(expected, si.peek());
    }
}
