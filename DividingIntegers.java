public class DividingIntegers {

    public void add(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    public void subtract(int num1, int num2) {
        System.out.println(num1 - num2);
    }

    public void multiply(int num1, int num2) {
        System.out.println(num1 * num2);
    }

    public void divide(int num1, int num2) {
        System.out.println((double) num1/num2);
    }

    public void modulos(int num1, int num2) {
        System.out.println(num1%num2);
    }

    public static void main(String []args) {
	DividingIntegers di = new DividingIntegers();
	int num1 = 1;
	int num2 = 2;

	di.add(num1, num2);

	di.subtract(num2, num1);

	di.multiply(num2, num1);

	di.divide(num1,num2);

	di.modulos(num1,num2);
    }
}
