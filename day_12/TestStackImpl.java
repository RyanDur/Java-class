import org.junit.*;
import static org.junit.Assert.*;

public class TestStackImpl {
    private Stack<String> si;

    @Before
    public void setup() {
	si = new StackImpl<>();
	si.push("Fliss");
    }

    @Test
    public void TestShouldAdddToStack() {
	String expected = "Fliss";
	assertEquals(expected, si.peek());
    }

    @Test
    public void TestShouldAddToTopOfStack() {
	String expected = "Dave";
	si.push(expected);
	assertEquals(expected, si.peek());
    }

    @Test
    public void TestShouldRemoveFromTopStack() {
	String expected = "Dave";
	si.push(expected);
	assertEquals(expected, si.peek());

	expected = "Fliss";
	si.pop();
	assertEquals(expected, si.peek());
    }

    @Test
    public void TestShouldRemoveFromTopAnReturnValueFromStack() {
	String expected = "Dave";
	si.push(expected);
	assertEquals(expected, si.peek());

	assertEquals(expected, si.pop());
    }
}
