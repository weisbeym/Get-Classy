import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom Wulf more or less, combines sample code from Big Java 4th edition
 * This sample program shows how to open a file and process it line by line
 */
public class PersonReader
{

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.showOpenDialog(null);
        String recordFile[];
        ArrayList<Person> userData = new ArrayList<>();
        String line;
        
        File file = chooser.getSelectedFile().getAbsoluteFile();
        
        String format1 = "%10s %12s %12s %12s %12s \n";
        String format2 = "%10s %12s %12s %12s %12d \n";
        
        System.out.format(format1, "Firstname" , "Lastname" , "Title" , "ID#" , "YOB");
        System.out.println("==========================================================================");
        Scanner in = new Scanner(file);
        
        while(in.hasNextLine())
        {
          line = in.nextLine();
          userData.add(new Person(line));
        }
          for(int i = 0; i < userData.size(); i++)
          {
          
              //prints the items from each object in a specified format-format2
              System.out.printf(format2, userData.get(i).getFirstName(),
                                         userData.get(i).getLastName(),
                                         userData.get(i).getTitle(),
                                         userData.get(i).getID(),
                                         userData.get(i).getYOB());
              
          }
     
    }
}
