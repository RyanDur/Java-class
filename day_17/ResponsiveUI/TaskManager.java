import java.io.*;

public class TaskManager {


    public static void main(String []args) throws InterruptedException {
        Console console = System.console();
        Thread[] threads = new Thread[10];
        String state = "";

        for(int i = 0; i < 10; i++) {
            System.out.println("Enter the duration (in ms) of task" + i + ":");
            long t = Long.parseLong(console.readLine());
            threads[i] = new Task(t,i);
	    threads[i].start();
            for(Thread thread : threads) {

	    }
            System.out.println("Finished tasks: " + state);
        }
    }
}
