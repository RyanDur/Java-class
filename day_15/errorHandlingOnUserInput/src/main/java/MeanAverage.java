import java.util.*;
import java.io.*;

public class MeanAverage {
    private int numberOfEntries;
    private ArrayList<Integer> numbers;

    public MeanAverage() {
        numberOfEntries = 10;
        numbers = new ArrayList<Integer>();
    }

    public void printMean() {
	int mean = 0;
	getNumbersFromUser();
	for(int i = 0; i < numbers.size(); i++) {
	    mean += numbers.get(i);
	}
	System.out.print(mean/numbers.size());
    }

    public void getNumbersFromUser() {
        Scanner scanner = new Scanner(System.in);
        while(numbers.size() < numberOfEntries) {
            try {
                check(scanner);
                numbers.add(scanner.nextInt());
            }
            catch (MyCustomException e) {
                System.out.println("Please input 10 numbers.\n" + e.getMessage());
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    public int[] getNumbers() {
        int[] result = new int[numbers.size()];
        for(int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }

    // I'm practicing exceptions
    private void check(Scanner scanner) throws MyCustomException {
        if(!scanner.hasNextInt()) {
            throw new MyCustomException("'"+ scanner.next() +"' is not a number");
        }
    }
}
