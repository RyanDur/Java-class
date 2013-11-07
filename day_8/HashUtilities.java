public class HashUtilities {
    public static int shortHash(int num) {
	int newNum = Math.abs(num);
	if(condition(newNum)) {
	    return newNum;
	}
	if(condition(newNum % 2)) {
	    return newNum % 2;
	}
	return shortHash(newNum/2);
    }

    private static boolean condition(int num) {
	return num < 1000 && num > 0;
    }
}
