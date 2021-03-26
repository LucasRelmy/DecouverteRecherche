import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class InputReader {
    public List<Element> getData(String path) {

        List<Element> liste = new ArrayList<Element>();
        try {
            File myObj = new File(path);
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                Element e = new Element();
                e.setWeight(scanner.nextInt());
                e.setPrice(scanner.nextInt());
                liste.add(e);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return liste;
    }
}
