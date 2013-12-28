import java.util.*;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TestAnagrams {

    @Test
    public void shouldGiveMeAllThePossibleAnagrams() {
        String[] cats =  {"cat", "cta", "tca", "act", "atc", "tac"};
        Set<String> catagram = new HashSet<String>(Arrays.asList(cats));
        String[] dogs =  {"dog", "dgo", "odg", "ogd", "gdo", "god"};
        Set<String> dogagram = new HashSet<String>(Arrays.asList(dogs));

        assertThat(Anagrams.getAnagrams("cat"), is(equalTo(catagram)));
        assertThat(Anagrams.getAnagrams("dog"), is(equalTo(dogagram)));
    }
}
