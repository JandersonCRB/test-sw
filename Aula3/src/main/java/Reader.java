import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
        try {
            FileReader fr = new FileReader(path);

            StringBuilder result = new StringBuilder();
            int i;
            while ((i=fr.read()) != -1){
                result.append((char) i);
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
