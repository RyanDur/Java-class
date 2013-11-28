import org.junit.*;
import static org.junit.Assert.*;

public class TestPracticeFindBugsOnce {
    PracticeFindBugsOnce p;

    @Before
    public void setup() {
        p = new PracticeFindBugsOnce();
    }

    @Test
    public void testsNormalName() {
        String input = "Dereck Robert Yssirt";
        String output = p.getInitials(input);
        String expected = "DRY";
        assertEquals(output, expected);
    }

    @Test
    public void testNameWithMoreThanOneSpace() {
        String input = "Dereck  Robert Yssir";
        String output = p.getInitials(input);
        String expected = "DRY";
        assertEquals(output, expected);
    }
}
