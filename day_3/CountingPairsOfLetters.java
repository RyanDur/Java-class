import java.io.*;

public class CountingPairsOfLetters {
    public static void main(String []args) {
        String letters = args[0];

        int pairs = 0;
        char letter = " ".charAt(0);
        for(int i = 0; i < letters.length()-1; i++) {
            if(letter == letters.charAt(i)) {
                pairs++;
            }
            letter = letters.charAt(i);
        }
        System.out.println(pairs);
    }
}
