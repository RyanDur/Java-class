import java.io.*;

public class BinaryAndDecimal {
    public int binary2decimal(String binary) {
	String reversed = new StringBuffer(binary).reverse().toString();
	int result = 0;
	for(int i = 0; i < reversed.length(); i++) {
	    result += Character.getNumericValue(reversed.charAt(i)) * Math.pow(2, i);
	}
        return result;
    }

    public String decimal2binary(int decimal) {
        String binary = "";
	while(decimal > 0) {
            if(decimal % 2 == 0) {
                binary += "0";
            } else {
                binary += "1";
            }
            decimal /= 2;
	}

        return new StringBuffer(binary).reverse().toString();
    }

    public static void main(String []args) {
        BinaryAndDecimal bad = new BinaryAndDecimal();

        System.out.println(bad.decimal2binary(100));
	System.out.println(bad.binary2decimal("1100100"));
    }
}
