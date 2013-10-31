import java.io.*;
import java.util.*;
//.split("(?<=\\G.{4})")

public class BinaryAndHexadecimal {
    Map<Character, String> hexadecimal = new HashMap<Character,String>();
    String[] binaryHex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E", "F"};
    int base = 0;

    public BinaryAndHexadecimal() {
        hexadecimal.put('0',"0000");
        hexadecimal.put('1',"0001");
        hexadecimal.put('2',"0010");
        hexadecimal.put('3',"0011");
        hexadecimal.put('4',"0100");
        hexadecimal.put('5',"0101");
        hexadecimal.put('6',"0110");
        hexadecimal.put('7',"0111");
        hexadecimal.put('8',"1011");
        hexadecimal.put('9',"1111");
        hexadecimal.put('A',"1010");
        hexadecimal.put('B',"1011");
        hexadecimal.put('C',"1100");
        hexadecimal.put('D',"1101");
        hexadecimal.put('E',"1110");
        hexadecimal.put('F',"1111");

        base = 16;
    }

    public String convert(String hexBin) {
        if(hexBin.contains("x")) {
            return hexToBinary(hexBin);
        } else {
            return binaryToHex(hexBin);
        }
    }

    private String binaryToHex(String binary) {
        String result = "";
        BinaryAndDecimal bad = new BinaryAndDecimal();
        int dec = bad.binary2decimal(binary);

        while(dec > 0) {
            result += binaryHex[dec % base];
	    dec /= base;
        }

        return "0x" + new StringBuffer(result).reverse().toString();
    }

    private String hexToBinary(String hex) {
        String result = "";
        for(int i = 2; i < hex.length(); i++) {
            result += hexadecimal.get(hex.charAt(i));
        }
        return result.replaceAll("^0+", "");
    }

    public static void main(String []args) {
        BinaryAndHexadecimal bad = new BinaryAndHexadecimal();

        System.out.println(bad.convert("1111011"));
        System.out.println(bad.convert("0x7B"));
    }
}
