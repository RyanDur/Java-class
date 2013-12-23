import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TestFibonacci {
    Fibonacci fib;
    @Before
    public void setup() {
        fib = new Fibonacci();
    }

    @Test
    public void shouldCalculateTheFibonacciNumbers() {
        Integer[] fibSequence = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765};

        for(int i = 0; i < fibSequence.length; i++) {
            assertThat(fibSequence[i], is(equalTo(fib.fib(i))));
        }
    }

    @Test
    public void shouldCalculateAndMemoizeTheFibonacciNumbers() {
        Integer[] fibSequence = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765};

        for(int i = 0; i < fibSequence.length; i++) {
            assertThat(fibSequence[i], is(equalTo(fib.fibMem(i))));
        }
    }
}
