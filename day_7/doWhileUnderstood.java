import java.io.*;

public class doWhileUnderstood {
    Console console;
    int studentCount;
    int distinctionCount;
    int passCount;
    int failCount;
    int invalidCount;

    public doWhileUnderstood() {
        console = System.console();
    }

    public void setMarks() {
        int mark;
        do {
            System.out.print("Input a mark: ");
            mark = Integer.parseInt(console.readLine());
            count(mark);
        } while(mark != -1);
    }

    public void print() {
        System.out.print("There are "+ (studentCount - invalidCount) +" students: ");
        System.out.print(distinctionCount + " distinctions, ");
        System.out.print(passCount + " pass, ");
        System.out.print(failCount + " fails ");
        System.out.println("(plus " + invalidCount + " invalid)");
    }

    private void count(int num) {
        if(num < 101) {
            studentCount++;
            if(num > 69) {
                distinctionCount++;
            } else if(num > 49) {
                passCount++;
            } else if(num >= 0) {
                failCount++;
            } else {
                invalidCount++;
            }
        }
    }
    public static void main(String []args) {
        doWhileUnderstood dwu = new doWhileUnderstood();

        dwu.setMarks();
        dwu.print();
    }
}
