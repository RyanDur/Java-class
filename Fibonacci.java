public class Fibonacci {

    public int fibonacci(int num) {
        if(num <= 2) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static void main(String []args) {
        Fibonacci fib = new Fibonacci();

	System.out.println(fib.fibonacci(10));
    }
}
