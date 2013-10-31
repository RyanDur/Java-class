import java.io.*;

public class PalindromeRecursion {

    public boolean palindromeRecurse(String pal, int start, int end) {
        if(pal.charAt(start) != pal.charAt(end)) {
            return false;
        }
	if(start == end || ((end) - start) == 1) {
	    return true;
	}
	return palindromeRecurse(pal, ++start, --end);
    }

    public static void main(String []args) {
        Console console = System.console();
        PalindromeRecursion pr = new PalindromeRecursion();

        String word = console.readLine();
        System.out.println(pr.palindromeRecurse(word, 0, word.length()-1));
    }

}
