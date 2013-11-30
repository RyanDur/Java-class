import org.junit.*;
import static org.junit.Assert.*;

public class TestBinaryTreeNode {

    @Test
    public void testShouldCompareOneNodeWithAnother() {
        BinaryTreeNode<Integer> btn1 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> btn2 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> btn3 = new BinaryTreeNode<>(6);

	assertFalse(btn1.lessThan(btn2));
	assertTrue(btn1.lessThan(btn3));

	BinaryTreeNode<String> btnString1 = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> btnString2 = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> btnString3 = new BinaryTreeNode<>("C");

	assertFalse(btnString1.lessThan(btnString2));
	assertTrue(btnString1.lessThan(btnString3));
    }
}
