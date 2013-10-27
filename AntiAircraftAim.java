import java.io.*;

public class AntiAircraftAim {

    public static void main(String []args) {
        Target target = new Target(5);
        Console console = System.console();
        Result result = null;
        int x;
        int y;
        int z;

        while(result != Result.HIT) {
            System.out.println("Here they come! Try to bring the plane down!");
            System.out.print("Enter a coordinate X: ");
            x = Integer.parseInt(console.readLine());
            System.out.print("Enter a coordinate Y: ");
            y = Integer.parseInt(console.readLine());
            System.out.print("Enter a coordinate Z: ");
            z = Integer.parseInt(console.readLine());


            result = target.fire(x,y,z);
	    System.out.println(result);
        }

    }
}
