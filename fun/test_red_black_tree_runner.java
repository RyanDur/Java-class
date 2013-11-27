import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class test_red_black_tree_runner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(test_red_black_tree.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
