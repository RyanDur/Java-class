import org.junit.*;
import static org.junit.Assert.*;

public class test_red_black_tree {

    @Test
    public void testShouldAddANodeToATree() {
        red_black_tree rbt = new red_black_tree();

        rbt.add(1);
        assertEquals("i: 1, c: b L[] R[]", rbt.toString());

        rbt.add(2);
        assertEquals("i: 1, c: b L[] R[i: 2, c: r L[] R[]]", rbt.toString());

        rbt.add(3);
        assertEquals("i: 1, c: b L[] R[i: 2, c: r L[] R[i: 3, c: r L[] R[]]]", rbt.toString());
    }

    @Test
    public void testShouldBalanaceTheTree() {
        red_black_tree rbt = new red_black_tree();

        rbt.add(1);
        rbt.add(2);
        assertEquals("i: 1, c: b L[] R[i: 2, c: r L[] R[]]", rbt.toString());

        rbt.add(1);
        rbt.add(2);
        rbt.add(3);
        assertEquals("i: 2, c: b L[i: 1, c: r L[] R[]] R[i: 3, c: r L[] R[]]", rbt.toString());
    }
}
