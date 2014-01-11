import java.io.*;

public class ListFile {

    public String[] files(String path) {
	return getFile(path).list();
    }

    private File getFile(String path) {
        return new File(path);
    }
}
