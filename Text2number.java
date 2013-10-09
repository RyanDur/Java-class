import java.io.*;
import java.math.BigDecimal;

public class Text2number {
    public static void main(String [] args) {
        String numberString = "";
        for(String number : args[0].split(",")) {
            numberString += number;
        }

        BigDecimal number = new BigDecimal(numberString);
        System.out.println(number.divide(new BigDecimal(2)));
    }
}
