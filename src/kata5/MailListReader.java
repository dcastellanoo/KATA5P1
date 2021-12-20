package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    public static boolean isMail(String line) {
        return line.matches("^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
    public static List<String> read(String filename) {
        List<String> emails = new ArrayList<>();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            while (true) {
                String line = reader.readLine();
                if(line == null) break;
                if (isMail(line)){
                    emails.add(line);
                }
            }
        } 
        catch (FileNotFoundException exception) {
            System.out.println("ERROR CurrencyLoaderArchive::loadAllCurrencies FileNotFoundException, " + exception.getLocalizedMessage());
        } catch (IOException ex) {
            System.out.println("ERROR CurrencyLoaderArchive::loadAllCurrencies IOException, " + ex.getLocalizedMessage());
        }
        
        
        return emails;
    }
}
