
package practica5_kata.persistance;

import practica5_kata.view.MailParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {

    public static List<String> read(String fileName) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while(true) {
                String line = reader.readLine();
                if (line == null) break;
                
                if(MailParser.isMail(line)) {
                    list.add(line);
                }    
            }
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR MailListReader::read (File not Found) " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("ERROR MailListReader::read (IO) " + exception.getMessage());
        }
        return list;
    }
    
}
