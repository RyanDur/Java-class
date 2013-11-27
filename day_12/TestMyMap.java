import org.junit.*;
import static org.junit.Assert.*;

public class TestMyMap {
    private MyMap mm;

    @Before
    public void setup() {
        mm = new MyMap();
    }

    @Test
    public void testShouldPutKeyAndValueIntoMap() {
        int index = 1;
        String name = "Fliss";
        mm.put(index, name);
        assertEquals(name, mm.get(index));

        index = 2;
        name = "Dave";
        mm.put(index, name);
        assertEquals(name, mm.get(index));

        index = 5;
        name = "Joe";
        mm.put(index, name);
        assertEquals(name, mm.get(index));
    }

    @Test
    public void testShouldNotAllowKeysLessThanZero() {
        int index = -1;
        String name = "Fliss";
        mm.put(index, name);
        assertEquals(null, mm.get(index));
    }

    @Test
    public void testShouldReturnNullIfKeyIsNotInMap() {
        int index = 1;
        String name = "Fliss";
        mm.put(index, name);

        assertEquals(null, mm.get(index+1));
    }

    @Test
    public void testShouldKnowIfAllValuesHaveBeenRemoved() {
        mm.put(1, "Fliss");
        mm.put(2, "Dave");
        mm.put(5, "Joe");

        assertFalse(mm.isEmpty());

        mm.remove(1);
        assertFalse(mm.isEmpty());

        mm.remove(2);
        assertFalse(mm.isEmpty());

        mm.remove(5);
        assertTrue(mm.isEmpty());
    }

    @Test
    public void testShouldRemoveValueAtGivenKeyInMap() {
        mm.put(1, "Fliss");
        mm.put(2, "Dave");
        mm.put(5, "Joe");

        int index = 2;
        mm.remove(index);
        assertEquals(null, mm.get(index));

        index = 5;
        mm.remove(index);
        assertEquals(null, mm.get(index));

        index = 1;
        mm.remove(index);
        assertEquals(null, mm.get(index));
    }
}
