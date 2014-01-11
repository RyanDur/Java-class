import org.junit.*;
import java.io.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

public class TestMeanAverage {
    private MeanAverage ma;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Before
    public void setup() {
        ma = new MeanAverage();
    }

    /**
     *  (a)
     *  Write a program that reads 10 numbers from
     *  the user and then prints the mean average.
     *  If the user inputs something that is not a number,
     *  the program should complain and ask for a number again
     *  until 10 numbers have been introduced.
     */

    @Test
    public void shouldRead10NumbersFromAUser() {
        systemInMock.provideText("1\n2\n3\n4\n5\n6\n7\n8\n9\n0");

        ma.getNumbersFromUser();
        int[] expected = {1,2,3,4,5,6,7,8,9,0};
        assertThat(expected, is(equalTo(ma.getNumbers())));
    }

    @Test
    public void shouldComplainIfUserDoesNotInputANUmber() {
        systemInMock.provideText("1\n2\n3\nthere\n4\n5\n6\n7\n8\n9\n0");

        ma.getNumbersFromUser();
        int[] expected = {1,2,3,4,5,6,7,8,9,0};
        assertThat(ma.getNumbers(), is(equalTo(expected)));
        assertThat(log.getLog(), is(equalTo("Please input 10 numbers.\n'there' is not a number\n")));
    }

    @Test
    public void shouldComplainIfUserDoesNotInput10NUmber() {
        systemInMock.provideText("1\n2\n3\n4\n5\n6\n7\n8\n9\n''\n0");

        ma.getNumbersFromUser();
        int[] expected = {1,2,3,4,5,6,7,8,9,0};
        assertThat(log.getLog(), is(equalTo("Please input 10 numbers.\n'\'\'' is not a number\n")));
        assertThat(ma.getNumbers(), is(equalTo(expected)));
    }

    @Test
    public void shouldPrintTheMeanAverageOfTheNumbersInput() {
	systemInMock.provideText("1\n2\n3\n4\n5\n6\n7\n8\n9\n0");

	ma.printMean();
        int expected = 4;
	assertThat(Integer.parseInt(log.getLog()), is(equalTo(expected)));
    }

    /**
     *  (b)
     *  Modify the program so that it first asks
     *  how many numbers the user wants to enter,
     *  and then asks for the numbers. The computer
     *  should complain if the user enters something
     *  that is not a number in both cases.
     *  Use methods to prevent code repetitions.
    */

    @Test
    public void shouldAskUseerToInputANumber() {}
}
