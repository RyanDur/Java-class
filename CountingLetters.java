import java.io.*;

public class CountingLetters {
    public static void main(String []args) {
        int count = 0;
        for(int i = 0; i < args[0].length(); i++) {
            if(args[0].charAt(i) == args[1].charAt(0)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
