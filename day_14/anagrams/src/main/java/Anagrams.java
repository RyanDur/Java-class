import java.util.*;

public class Anagrams {
    private static String[] result;

    public static Set<String> getAnagrams(String word) {
        int length = Factorial.fac(word.length());
        result = new String[length];
	anag(word, "");
	String[] anagrams = result;
	result = null;
        return new HashSet<String>(Arrays.asList(anagrams));
    }

    private static void anag(String s1, String s2)  {
        if(s1.length() == 0) {
	    int j = 0;
	    while(result[j] != null) {j++;}
            result[j] = s2;
        }
        for(int i = 0; i < s1.length(); i++) {
            anag(s1.substring(0, i) + s1.substring(i+1, s1.length()), s1.charAt(i) + s2);
        }
    }

}
