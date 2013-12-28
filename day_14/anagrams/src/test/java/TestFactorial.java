import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TestFactorial {

    @Test
    public void shouldReturnTheFactorialOfANumber() {
	int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	for(int i = 0; i < factorials.length; i++) {
	    assertThat(factorials[i], is(equalTo(Factorial.fac(i))));
	}
    }
}
