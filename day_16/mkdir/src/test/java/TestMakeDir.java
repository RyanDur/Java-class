import org.junit.*;
import java.io.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

public class TestMakeDir {
    MakeDir md;
    File file;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Before
    public void setup() {
        md = new MakeDir();
    }

    @After
    public void teardown() {
        file.delete();
        assertThat(file.exists(), is(equalTo(false)));
    }

    @Test
    public void shouldMakeADirectoryFromUserInput() {
        systemInMock.provideText("button");
        md.mkdir();
        file = new File("button");
        assertThat(file.exists(), is(equalTo(true)));
    }
}
