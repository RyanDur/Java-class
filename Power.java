import java.io.*;

public class Power {

    public static int pow(int base, int exponent) {
	if(exponent == 1) {
	    return base;
	}
	return base * pow(base, exponent-1);
    }

    public static void main(String []args) {
	System.out.println(Power.pow(5,2));
    }
}
