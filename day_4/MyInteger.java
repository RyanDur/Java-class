import java.io.*;

public class MyInteger {
    private int myInt;

    public int getValue() {
	return myInt;
    }

    public void setValue(int myInt) {
	this.myInt = myInt;
    }

    public boolean isEven() {
	return myInt % 2 == 0;
    }

    public boolean isOdd() {
	return !isEven();
    }

    public void prettyPrint() {
	System.out.println(myInt);
    }

    public String toString() {
	return Integer.toString(myInt);
    }

    public static void main(String []args) {
        MyInteger i2 = new MyInteger();
        System.out.print("Enter a number: ");
        String str = System.console().readLine();
	int i = Integer.parseInt(str);
	i2.setValue(i);
        System.out.print("The number you entered is ");
            if (i2.isEven()) {
                System.out.println("even.");
            } else if (i2.isOdd()) {
                System.out.println("odd.");
            } else {
                System.out.println("undefined!! Your code is buggy!");
	    }
        int parsedInt = Integer.parseInt(i2.toString());
	if (parsedInt == i2.getValue()) {
            System.out.println("Your toString() method seems to work fine.");
	}
    }
}
