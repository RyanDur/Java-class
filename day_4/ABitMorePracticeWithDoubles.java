import java.io.*;
import java.math.BigDecimal;

public class ABitMorePracticeWithDoubles {
    Double borrowed;
    Double yearsToPayBack;
    Double interestRate;

    public ABitMorePracticeWithDoubles(Double borrowed, Double yearsToPayBack, Double interestRate) {
	this.borrowed = borrowed;
	this.yearsToPayBack = yearsToPayBack;
	this.interestRate = interestRate;
    }

    public Double total() {
	return borrowed * ((interestRate / 100) + 1);
    }

    public Double annualPayBack() {
	return total() / yearsToPayBack;
    }

    public Double interestDeath() {
	return (total() - borrowed) / annualPayBack();
    }

    public static void main(String []args) {
        Console console = System.console();
        System.out.print("Your total amount borrowed for the mortgage: ");
        Double borrowed = new Double(console.readLine());
        System.out.print("The number of years to pay it back: ");
        Double yearsToPayBack = new Double(console.readLine());
        System.out.print("The Interest rate: ");
        Double interestRate = new Double(console.readLine());

	ABitMorePracticeWithDoubles abmpwd = new ABitMorePracticeWithDoubles(borrowed, yearsToPayBack, interestRate);

	System.out.println(abmpwd.total());
	System.out.println(abmpwd.annualPayBack());
	System.out.println(abmpwd.interestDeath());
    }
}
