import org.junit.*;
import static org.junit.Assert.*;

public class test_red_black_tree {

    @Test
    public void testShouldAddANodeToATree() {
        red_black_tree rbt = new red_black_tree();

        rbt.add(1);
        assertEquals("1 L[] R[]", rbt.toString());

        rbt.add(2);
        assertEquals("1 L[] R[2 L[] R[]]", rbt.toString());

        rbt.add(3);
        assertEquals("1 L[] R[2 L[] R[3 L[] R[]]]", rbt.toString());

    }
}
