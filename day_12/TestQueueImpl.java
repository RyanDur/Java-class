import org.junit.*;
import static org.junit.Assert.*;

public class TestQueueImpl {
    private Queue<Integer> q;

    @Before
    public void setup() {
        q = new QueueImpl<>();
    }

    @Test
    public void testShouldInsertAValueToTheEndOfAQueue() {
        Integer expected = 1;
        q.insert(expected);
        assertEquals(expected, q.retrieve());

        Integer nextExpected = 1;
        q.insert(expected);
        q.insert(nextExpected);
        q.insert(3);

        assertEquals(expected, q.retrieve());
        assertEquals(nextExpected, q.retrieve());
    }

    @Test
    public void testShouldReturnNullIfListIsEmoty() {
	assertEquals(null, q.retrieve());
    }
}
