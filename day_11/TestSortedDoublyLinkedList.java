import org.junit.*;
import static org.junit.Assert.*;

public class TestSortedDoublyLinkedList {

    @Test
    public void testShouldSortTheListOnAddition() {
	SortedDoublyLinkedList<Integer> sdll = new SortedDoublyLinkedList<>();
        Integer num = 2;
        Integer num1 = 3;
        Integer num2 = 1;
        sdll.add(num);
        sdll.add(num1);
        sdll.add(num2);
        assertEquals(num2 +" "+ num +" "+ num1, sdll.toString());
    }
}
