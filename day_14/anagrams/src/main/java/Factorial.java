public class Factorial {

    public static int fac(int num) {
	if(num <= 1) return 1;
	return num * fac(num-1);
    }
}
