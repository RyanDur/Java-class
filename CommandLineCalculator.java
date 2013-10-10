import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;

public class CommandLineCalculator {
    public static void main(String []args) {
        CommandLineCalculator clc = new CommandLineCalculator();
        Pattern pattern = Pattern.compile("((\\d+)|([\\+\\-\\*/\\(\\)]))");
        Matcher matched = pattern.matcher(args[0]);
        ArrayList<String> matches = new ArrayList<String>();
        while(matched.find()) {
            matches.add(matched.group());
        }

        String op = matches.get(1);
        double leftHand = Double.parseDouble(matches.get(0));
        double rightHand = Double.parseDouble(matches.get(2));

        if(op.equals("+")) {
            clc.print(leftHand+rightHand);
        } else if(op.equals("-")) {
            clc.print(leftHand-rightHand);
        } else if(op.equals("*")) {
            clc.print(leftHand*rightHand);
        } else if(op.equals("/")) {
            clc.print(leftHand/rightHand);
        } else {
            System.out.println("That is not an expression I can handle fool");
        }
    }

    public void print(double num) {
        if(num % 1 == 0) {
            System.out.println((int)num);
        } else {
            System.out.println(num);
        }
    }
}
