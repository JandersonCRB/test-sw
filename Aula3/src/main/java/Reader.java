import java.io.*;
import java.nio.charset.StandardCharsets;

public class Reader {

    /**
     * This method reads a text file from a specified path
     * and returns it as a String.
     * It must use FileInputStream
     *
     * @param path relative path to a text file to be read
     * @return text file as string
     */
    public String readAll(String path) {
        File file = new File(path);
        byte[] buffer = new byte[4096];
        try {
            FileInputStream fis = new FileInputStream(file);
            int size = fis.read(buffer);
            byte[] auxBuffer = new byte[size];
            System.arraycopy(buffer, 0, auxBuffer, 0, size);
            return new String(auxBuffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
