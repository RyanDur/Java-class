import org.junit.*;
import static org.junit.Assert.*;

public class TestBinarySearchTree {
    private BinarySearchTree<Integer> bst;

    @Before
    public void setup() {
        bst = new BinarySearchTreeImpl<>();
    }

    /**
     *  [1]
     */
    @Test
    public void testShouldAddValueToHeadOFTreeIfEmpty() {
        bst.add(1);
        assertEquals("1 L[] R[]", bst.toString());
    }

    /**
     *  [1]
     *    \
     *     [2]
     */
    @Test
    public void testShouldAddValueToTheRightIfValueIsGreater() {
        bst.add(1);
        bst.add(2);
        assertEquals("1 L[] R[2 L[] R[]]", bst.toString());
    }

    /**
     *  [1]
     *    \
     *     [1]
     */
    @Test
    public void testShouldAddValueToTheRightIfValueIsEqual() {
        bst.add(1);
        bst.add(1);
        assertEquals("1 L[] R[1 L[] R[]]", bst.toString());
    }

    /**
     *     [2]
     *     /
     *  [1]
     */

    @Test
    public void testShouldAddValueToTheLeftIfValueIsLess() {
        bst.add(2);
        bst.add(1);
        assertEquals("2 L[1 L[] R[]] R[]", bst.toString());
    }

    @Test
    public void testShouldReturnZeroIfThereIsNoTree() {
        assertEquals(0, bst.depth());
    }

    @Test
    public void testShouldRetrieveTheDepthOfTheTree() {
        bst.add(2);
        assertEquals(1, bst.depth());

        bst.add(1);
        assertEquals(2, bst.depth());

        bst.add(3);
        assertEquals(2, bst.depth());

        bst.add(2);
        assertEquals(3, bst.depth());
    }

    /**
     *       [3]
     *       /   --\    [2]
     *     [2]   --/    / \
     *     /          [1] [3]
     *   [1]
     */
    @Test
    public void testShouldBalnaceLeftHandTree() {
        bst.add(3);
        bst.add(2);
        bst.add(1);
        assertEquals("2 L[1 L[] R[]] R[3 L[] R[]]", bst.toString());
    }


    /**
     *   [1]
     *     \     --\    [2]
     *     [2]   --/    / \
     *       \        [1] [3]
     *       [3]
     */
    @Test
    public void testShouldBalnaceRightHandTree() {
        bst.add(1);
        bst.add(2);
        bst.add(3);
        assertEquals("2 L[1 L[] R[]] R[3 L[] R[]]", bst.toString());
    }

    /**
     *     [3]
     *     /     --\    [2]
     *   [1]     --/    / \
     *     \          [1] [3]
     *     [2]
     */
    @Test
    public void testShouldBalnaceLeftRightTree() {
        bst.add(3);
        bst.add(1);
        bst.add(2);
        assertEquals("2 L[1 L[] R[]] R[3 L[] R[]]", bst.toString());
    }

    /**
     *   [1]
     *     \     --\    [2]
     *     [3]   --/    / \
     *     /          [1] [3]
     *   [2]
     */
    @Test
    public void testShouldBalnaceRightLeftTree() {
        bst.add(1);
        bst.add(3);
        bst.add(2);
        assertEquals("2 L[1 L[] R[]] R[3 L[] R[]]", bst.toString());
    }

    /**
     * input   ->     0 - 9
     *
     * outcome ->      [3]
     *                /   \
     *             [1]     [7]
     *            /  \     /  \
     *         [0]   [2] [5]   [8]
     *                   / \      \
     *                 [4] [6]     [9]
     */
    @Test
    public void testShouldBalnaceTree() {
        for(int i = 0; i < 10; i++) {
            bst.add(i);
        }
        assertEquals("3 L[1 L[0 L[] R[]] R[2 L[] R[]]] R[7 L[5 L[4 L[] R[]] R[6 L[] R[]]] R[8 L[] R[9 L[] R[]]]]", bst.toString());
    }

    @Test
    public void testShouldRetrieveTheMinimalValue() {
        for(int i = 0; i < 10; i++) {
            bst.add(i);
        }
        Integer expected = 0;
        assertEquals(expected, bst.getMin());
    }

    @Test
    public void testShouldRetrieveTheMaximumValue() {
        for(int i = 0; i < 10; i++) {
            bst.add(i);
        }
        Integer expected = 9;
        assertEquals(expected, bst.getMax());
    }

    @Test
    public void testShouldKnowIfTreeContainsValue() {
        for(int i = 0; i < 10; i++) {
            bst.add(i);
        }
        assertEquals(true, bst.contains(0));
        assertEquals(true, bst.contains(9));
        assertEquals(false, bst.contains(10));
        assertEquals(true, bst.contains(5));
    }

    /**
     *  [1] -> null
     */
    @Test
    public void testShouldContainNothingIfTreeIsEmpty() {
        Integer value = 1;
        bst.add(value);
        bst.delete(value);
        assertEquals(false, bst.contains(value));
        assertEquals("", bst.toString());
    }

    /**
     *    [2]       [2]
     *    / \   ->    \
     *  [1] [3]       [3]
     *
     *    [2]
     *      \   ->  [2]
     *      [3]
     */
    @Test
    public void testShouldRemoveLeaf() {
        Integer value1 = 1;
        Integer value2 = 2;
        Integer value3 = 3;

        bst.add(value3);
        bst.add(value1);
        bst.add(value2);

        bst.delete(value1);
        assertEquals(false, bst.contains(value1));
        assertEquals("2 L[] R[3 L[] R[]]", bst.toString());

        bst.delete(value3);
        assertEquals(false, bst.contains(value3));
        assertEquals("2 L[] R[]", bst.toString());
    }


    /**
     *    [2]
     *    /     ->  [1]
     *  [1]
     *
     *    [1]
     *      \   ->  [2]
     *      [2]
     */
    @Test
    public void testShouldRemoveRoot() {
        Integer value1 = 1;
        Integer value2 = 2;

        bst.add(value2);
        bst.add(value1);

        bst.delete(value2);
        assertEquals(false, bst.contains(value2));
        assertEquals("1 L[] R[]", bst.toString());

        bst.add(value2);
        bst.delete(value1);
        assertEquals(false, bst.contains(value1));
        assertEquals("2 L[] R[]", bst.toString());
    }

    /**
     *                  [10] <- remove
     *                 /    \
     *              [5]      [17]
     *             /  \      /  \
     *          [3]   [9]  [15]  [20]
     *         /     /              \
     *      [1]    [7]              [22]
     *
     *
     *                  [9]
     *                 /   \
     *              [5]     [17] <- remove
     *             /  \     /  \
     *          [3]   [7] [15]  [20]
     *         /                   \
     *      [1]                    [22]
     *
     *
     *                  [9]
     *                 /   \
     *              [5]     [20] <- remove
     *             /  \     /  \
     *          [3]   [7] [15]  [22]
     *         /
     *      [1]
     *
     *
     *                  [9]
     *                 /   \
     *              [5]     [15] <- remove
     *             /  \        \
     *          [3]   [7]       [22]
     *         /
     *      [1]
     *
     *
     *                  [5]
     *                 /   \
     *              [3]     [9]
     *             /       /   \
     *          [1]      [7]   [22]
     */
    @Test
    public void testShouldRemoveFromLargeTreeAndRebalance() {
        int[] nums = {10, 5, 15, 3, 9, 20, 1, 7, 17, 22};
        for(int num : nums) {
            bst.add(num);
        }

        assertEquals("10 L[5 L[3 L[1 L[] R[]] R[]] R[9 L[7 L[] R[]] R[]]] R[17 L[15 L[] R[]] R[20 L[] R[22 L[] R[]]]]", bst.toString());

        bst.delete(10);
        assertEquals("9 L[5 L[3 L[1 L[] R[]] R[]] R[7 L[] R[]]] R[17 L[15 L[] R[]] R[20 L[] R[22 L[] R[]]]]", bst.toString());

        bst.delete(17);
        assertEquals("9 L[5 L[3 L[1 L[] R[]] R[]] R[7 L[] R[]]] R[20 L[15 L[] R[]] R[22 L[] R[]]]", bst.toString());

        bst.delete(20);
        assertEquals("9 L[5 L[3 L[1 L[] R[]] R[]] R[7 L[] R[]]] R[15 L[] R[22 L[] R[]]]", bst.toString());

	bst.delete(15);
        assertEquals("5 L[3 L[1 L[] R[]] R[]] R[9 L[7 L[] R[]] R[22 L[] R[]]]", bst.toString());
    }
}
