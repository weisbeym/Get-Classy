
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yisroel
 */
public class ProductGenerator {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        String ID;
        String name;
        String description;
        double cost;
        boolean done = false;
        String fileName;
        
        ArrayList <String> productList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        
        //asks for file name and creates it
        System.out.println("Enter A file name.");
        fileName = in.nextLine();
        File productRecordsFile = new File(fileName + ".txt");
        
        //tests file
        try(PrintWriter out = new PrintWriter(productRecordsFile))
        {
        
            do 
            {
            
                //prompt and receive user input
                System.out.println("Please enter the product name.");
                name = in.nextLine();
                System.out.println("Please enter the product description.");
                description = in.nextLine();
                System.out.println("Please enter your 6 digit ID number.");
                ID = in.nextLine();
                cost = SafeInput.getRangedDouble(in, "Please enter the product cost. ", 1, 9999);

                Product item = new Product(name, description, ID, cost);
                
                productList.add(item.toCSVRecord());

                //ask user if they want to add another products data, if yes loop again, if no end loop.
                if(!SafeInput.getYNConfirm(in, "Would you like to add another product's data y/n?"))
                {
                    done = true;
                }
            
            } while(!done);
            
            for(int i = 0; i < productList.size(); i++)
            {
            
                out.println(productList.get(i));
            
            }
            
            System.out.println(fileName + ".txt" + " was created.");
            
        }
       
    }
    
}
