import org.junit.*;
import java.io.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TestListFile {
    private ListFile ls;

    @Before
    public void setup() {
        ls = new ListFile();
    }

    @Test
    public void shouldListTheFilesInADirectory() {
        String[] expected = {"main", "test"};
        assertThat(ls.files("./src"), is(equalTo(expected)));
    }
}
