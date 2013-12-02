import org.junit.*;
import static org.junit.Assert.*;

public class TestComarator {

    @Test
    public void testShouldReturnMaximumInteger() {
        Comparator<Integer> c = new Comparator<>();
        Integer d1 = 1;
        Integer d2 = 2;
        assertEquals(d2, c.getMax(d1,d2));
    }

    @Test
    public void testShouldReturnMaximumDouble() {
        Comparator<Double> c = new Comparator<>();
        Double d1 = 1.5;
        Double d2 = 2.5;
        assertEquals(d2, c.getMax(d1,d2), 0);
    }

    @Test
    public void testShouldReturnMaximumIntergerOfString() {
        Comparator<String> c = new Comparator<>();
        String d1 = "1";
        String d2 = "2";
        assertEquals(d2, c.getMax(d1,d2));
    }
}
