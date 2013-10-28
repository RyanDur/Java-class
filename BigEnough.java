import java.io.*;

public class BigEnough {

    public void print(MyArrays arrs) {
        for(int i = 0; i < arrs.size(); i++) {
            String[] x = arrs.get(i);
            if((Integer.parseInt(x[0]) % 2 == 0 || x[1].charAt(0) == 'S') && Integer.parseInt(x[0]) != 0) {
                System.out.println(x[0] + ", " + x[1]);
            }
        }
    }

    public static void main(String []args) {
        Console console = System.console();
        MyArrays arrs = new MyArrays();
        BigEnough be = new BigEnough();
        int id = -1;
        String name = " ";

        while(true) {
            System.out.print("Enter an employee id: ");
            id = Integer.parseInt(console.readLine());
            if(id == 0){
                break;
            }
            System.out.print("Enter an employee name: ");
            name = console.readLine();
            if(name.length() == 0) {
                break;
            }
            arrs.add(id,name);
        }

        be.print(arrs);
    }
}
