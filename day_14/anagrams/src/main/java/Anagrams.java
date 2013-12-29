import java.util.*;

public class Anagrams {

    public static Set<String> getAnagrams(String word) {
	String[] anagrams = anag(word, "", new String[Factorial.fac(word.length())]);
        return new HashSet<String>(Arrays.asList(anagrams));
    }

    private static String[] anag(String word, String anagram, String[] result) {
        if(word.length() == 0) {
	    int j = 0;
	    while(result[j] != null) {j++;}
            result[j] = anagram;
        }
        for(int i = 0; i < word.length(); i++) {
            result = anag(word.substring(0, i) + word.substring(i+1, word.length()),
			  word.charAt(i) + anagram, result);
        }
	return result;
    }
}
