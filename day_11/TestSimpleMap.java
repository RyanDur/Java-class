import org.junit.*;
import static org.junit.Assert.*;

public class TestSimpleMap {
    private SimpleMap<String, String> sm;

    @Before
    public void setup() {
        sm = new SimpleMapImpl<>();
    }

    @Test
    public void testShouldPutIntoMap() {
        String key = "Hello";
        String value = "World";

        sm.put(key, value);
        assertEquals(value, sm.get(key));
    }

    @Test
    public void testShouldBeAbleToRemoveAValueFromTheMap() {
        String key = "pneumonoultramicroscopicsilicovolcanoconiosis";
        String value = "World";

        assertEquals(null, sm.get(key));

        sm.put(key, value);
        assertEquals(value, sm.get(key));

        sm.remove(key);
        assertEquals(null, sm.get(key));
    }

    @Test
    public void testShouldReplaceValueIfKeysHashCodeIsTheSame() {
        String key1 = "BB";
        String key2 = "Aa";
        String value1 = "World";
        String value2 = "FooBar";

        sm.put(key1, value1);
        assertEquals(value1, sm.get(key1));

        sm.put(key2, value2);
        assertEquals(value2, sm.get(key1));
    }
}
