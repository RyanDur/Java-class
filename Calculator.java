import java.io.*;

public class Calculator {
    public static void main(String []args) {
        Console console = System.console();
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);
        Calculator calc = new Calculator(number1, number2);

        calc.menu();

        int choice = Integer.parseInt(console.readLine());
        System.out.println("  ");

        calc.calculate(choice);
    }

    private int number1 = 0;
    private int number2 = 0;

    public Calculator(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public void menu() {
        System.out.println("  ");
        System.out.println("choose an operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("  ");
    }

    public void calculate(int choice) {
        if (choice == 1) {
            System.out.println(number1 + number2);
        } else if (choice == 2) {
            System.out.println(number1 - number2);
        } else if (choice == 3) {
            System.out.println(number1 * number2);
        } else if (choice == 4) {
            System.out.println(number1 / number2);
        } else {
            System.out.println("That was not a choice");
        }
    }
}
