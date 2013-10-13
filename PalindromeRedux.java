import java.io.*;

public class PalindromeRedux {
    public boolean isPalindrome(String text) {
        int stringLength = text.length()-1;

        for(int i = 0; i < text.length()/2; i++) {
            if(text.charAt(i) != text.charAt(stringLength)) {
                return false;
            }
            stringLength--;
        }
        return true;
    }

    public static void main(String []args) {
        Console console = System.console();
        PalindromeRedux pr = new PalindromeRedux();
        System.out.print("Please write a text: ");
        String text = console.readLine().replaceAll("\\W", "").toLowerCase();
        System.out.println(pr.isPalindrome(text));
    }
}
