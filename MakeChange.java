import java.io.*;
import java.math.BigDecimal;

public class MakeChange {
    public static void main(String []args) {
        BigDecimal price = new BigDecimal(args[0]);
        BigDecimal paid = new BigDecimal(args[1]);

        System.out.println(paid.subtract(price).setScale(2));
    }
}
