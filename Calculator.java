import java.io.*;

public class Calculator {
    public static void main(String []args) {
        System.out.println("Please input two numbers: ");

        Console console = System.console();
        String numbers = console.readLine();
        System.out.println(numbers.length());
    }
}
