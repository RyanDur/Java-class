import java.io.*;

public class Palindrome {
    public static void main(String []args) {
        String reversed = new StringBuffer(args[0]).reverse().toString();

        if (args[0].equals(reversed)) {
            System.out.println("Palindrome detected");
        }
    }
}
