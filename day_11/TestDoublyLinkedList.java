import org.junit.*;
import static org.junit.Assert.*;

public class TestDoublyLinkedList {
    DoublyLinkedList<Integer> dll;

    @Before
    public void setup() {
        dll = new DoublyLinkedListImpl<>();
    }

    @Test
    public void testShouldAddToList() {
        assertEquals("", dll.toString());

        Integer num = 1;
        dll.add(num);
        assertEquals(num.toString(), dll.toString());

        Integer num1 = 2;
        dll.add(num1);
        assertEquals(num +" "+ num1, dll.toString());

        Integer num2 = 3;
        dll.add(num2);
        assertEquals(num +" "+ num1 +" "+ num2, dll.toString());
    }

    @Test
    public void testShouldRemoveFromEndOfList() {
        Integer num = 1;
        Integer num1 = 2;
        Integer num2 = 3;
        dll.add(num);
        dll.add(num1);
        dll.add(num2);
        assertEquals(num +" "+ num1 +" "+ num2, dll.toString());

        dll.delete(num2);
        assertEquals(num +" "+ num1, dll.toString());

        dll.delete(num1);
        assertEquals(num.toString(), dll.toString());

        dll.delete(num);
        assertEquals("", dll.toString());
    }

    @Test
    public void testShouldRemoveFromWithinTheList() {
        Integer num = 1;
        Integer num1 = 2;
        Integer num2 = 3;
        dll.add(num);
        dll.add(num1);
        dll.add(num2);
        assertEquals(num +" "+ num1 +" "+ num2, dll.toString());

        dll.delete(num1);
        assertEquals(num +" "+ num2, dll.toString());
    }

    @Test
    public void testShouldReturnTheNodeCount() {
        Integer num = 1;
        Integer num1 = 2;
        Integer num2 = 3;

        assertEquals(0, dll.size());

        dll.add(num);
        assertEquals(1, dll.size());

        dll.add(num1);
        assertEquals(2, dll.size());

        dll.add(num2);
        assertEquals(3, dll.size());
    }
}
