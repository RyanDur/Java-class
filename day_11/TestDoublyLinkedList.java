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

}
