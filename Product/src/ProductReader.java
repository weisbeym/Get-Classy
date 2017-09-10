
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yisroel
 */
public class ProductReader {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        JFileChooser fileChoise = new JFileChooser();
        fileChoise.setCurrentDirectory(new java.io.File("."));
        fileChoise.showOpenDialog(null);
        File file = fileChoise.getSelectedFile().getAbsoluteFile();
        String recordFile[];
        ArrayList<Product> productList = new ArrayList<>();
        
        String format1 = "%20s%20s%25s%20s\n";
        String format2 = "%20s %30s %15s %15.2f \n";
        String divider = "=========================================================================================";
        System.out.format(format1, "Name" , "Description" , "ID#" , "Cost");
        System.out.println(divider);
        String line;
        
        Scanner in = new Scanner(file);
        
         while(in.hasNextLine())
        {
          line = in.nextLine();
          productList.add(new Product(line));
        }
          for(int i = 0; i < productList.size(); i++)
          {
          
              //prints the items from each object in a specified format-format2
              System.out.printf(format2, productList.get(i).getName(),
                                         productList.get(i).getDescription(),
                                         productList.get(i).getID(),
                                         productList.get(i).getCost());
                                         
              
          }
    }
    
}
