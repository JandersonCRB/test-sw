import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Reader {

    /**
     * This method reads a text file from a specified path
     * and returns it as a String.
     *
     * @param path relative path to a text file to be read
     * @param charset an value from StandardCharsets representing the file charset
     * @return text file as string
     */
    private String _readAll(String path, Charset charset) {
        File file = new File(path);
        try {
            FileInputStream fis = new FileInputStream(file);
            RandomAccessFile f = new RandomAccessFile(path, "r");

            long expectedSize = f.length();
            byte[] buffer = new byte[(int) expectedSize];

            int size = fis.read(buffer);
            byte[] auxBuffer = new byte[size];
            System.arraycopy(buffer, 0, auxBuffer, 0, size);

            fis.close();
            f.close();
            return new String(auxBuffer, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method reads a text file from a specified path
     * and returns it as a String.
     * The file must be in UTF-8 encoding
     *
     * @param path relative path to a text file to be read
     * @return text file as string
     */
    public String readAll(String path) {
        return _readAll(path, StandardCharsets.UTF_8);
    }

    /**
     * This method reads a text file from a specified path
     * and returns it as a String.
     *
     * @param path relative path to a text file to be read
     * @param charset an value from StandardCharsets representing the file charset
     * @return text file as string
     */
    public String readAll(String path, Charset charset) {
        return _readAll(path, charset);
    }
}
