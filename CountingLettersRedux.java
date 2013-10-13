import java.io.*;

public class CountingLettersRedux {
    String text = null;
    String[] usedLetters = null;

    public CountingLettersRedux(String text) {
        this.text = text;
        usedLetters = new String[text.length()];
    }

    public boolean letterUsed(String letter) {
        if (letter == null) {
            return false;
        }
        for(int i = 0; i < usedLetters.length; i++) {
            if(letter.equals(usedLetters[i])) {
                return true;
            }
        }
        add(letter);
        return false;
    }

    public int letterCount(String letter) {
        int count = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == letter.charAt(0)) {
                count ++;
            }
        }
        return count;
    }

    private void add(String letter) {
        int count = 0;
        while(usedLetters[count] != null) {
            count++;
        }
        if(count < usedLetters.length) {
            usedLetters[count] = letter;
        }
    }


    public static void main(String []args) {
        Console console = System.console();
        String letter = null;
        boolean stop = false;

        System.out.print("Please write a text: ");
        CountingLettersRedux clr = new CountingLettersRedux(console.readLine());

        do {
            System.out.print("Which letter would you like to count now? ");
            letter = console.readLine();
            if (!clr.letterUsed(letter)) {
                System.out.println("There are "+ clr.letterCount(letter) +" in your text.");
            } else {
                System.out.println("Repeated character. Exiting the program...");
                stop = true;
            }
        } while(!stop);

        System.out.println("Thank you for your cooperation. Good bye!");
    }
}
