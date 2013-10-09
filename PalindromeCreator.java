import java.io.*;

public class PalindromeCreator {
    public static void main(String []args) {
        PalindromeCreator pc = new PalindromeCreator();
        System.out.println(pc.toLine(args) + pc.reverseLine(args));
    }

    public String toLine(String []line) {
        String wholeLine = "";
        for (String word : line) {
            wholeLine += word + " ";
        }
        return wholeLine.trim();
    }

    public String reverseLine(String []line) {
        String reversedLine = "";
        for (int i = line.length - 1; i >= 0; i--) {
            reversedLine += reverseWord(line[i]) + " ";
        }
        return reversedLine.trim();
    }

    private String reverseWord(String word) {
        String reversed = "";
        for (int i = word.length()-1; i >= 0; i--) {
            reversed += word.charAt(i);
        }
        return reversed;
    }
}
