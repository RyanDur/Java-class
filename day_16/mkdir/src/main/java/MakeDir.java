import java.io.*;
import java.util.*;

public class MakeDir {

    public void mkdir() {
        Scanner scanner = new Scanner(System.in);
        String dirName = scanner.next();
	scanner.close();
	new File(dirName).mkdir();
    }
}
