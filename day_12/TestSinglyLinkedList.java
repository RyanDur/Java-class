import org.junit.*;
import static org.junit.Assert.*;

public class TestSinglyLinkedList {
    private SinglyLinkedList<Integer> sll;

    @Before
    public void setup() {
        sll = new SinglyLinkedList<>();
    }

    @Test
    public void testShouldBeAbleToAddToList() {
        Integer expected = 1;
        sll.add(expected);

        assertEquals(expected.toString(), sll.toString());

        Integer expected1 = 2;
        sll.add(expected1);

        assertEquals(expected + ", " + expected1, sll.toString());
    }

    @Test
    public void testShouldBeAbleToRemoveFromTheList() {
        Integer expected = 1;
        Integer expected1 = 2;
        Integer expected2 = 3;
        sll.add(expected);

        sll.remove(expected);
        assertEquals("", sll.toString());

        sll.add(expected);
        sll.add(expected1);
        sll.add(expected2);
        assertEquals(expected + ", " + expected1 + ", " + expected2, sll.toString());

        sll.remove(expected);
        assertEquals(expected1 + ", " + expected2, sll.toString());
    }
}
