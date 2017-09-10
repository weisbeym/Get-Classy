
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yisroel
 */
public class PersonGenerator {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
         
        Scanner in = new Scanner(System.in);
        String ID;
        String firstName;
        String lastName;
        String title;
        int YOB;
        boolean done = false;
        String fileName;
        
        ArrayList<String> personalData = new ArrayList<>();
        
        System.out.println("Enter a file name.");
        fileName = in.nextLine();
        File PersonalRecordsFile = new File(fileName + ".txt");
        
        try(PrintWriter out = new PrintWriter(PersonalRecordsFile))
        {
            do
            {
                //prompt and receive user input
                System.out.println("Please enter your 6 digit ID number.");
                ID = in.nextLine();
                System.out.println("Please enter your first name.");
                firstName = in.nextLine();
                System.out.println("Please enter your last name.");
                lastName = in.nextLine();
                System.out.println("Please enter your title. (Mr, Mrs, Dr, ect.)");
                title = in.nextLine();
                YOB = SafeInput.getRangedInt(in, "Please enter your year of birth. ", 1940, 2000);

                Person user = new Person(firstName, lastName, title, ID, YOB);
                // add all the fields, in proper format, into the array list
                personalData.add(user.toCSVRecord());

                //ask user if they want to add another persons data, if yes loop again, if no end loop.
                if(!SafeInput.getYNConfirm(in, "Would you like to add another users data y/n?"))
                {
                    done = true;
                }

            }while (!done);
            
            //increment ArrayList to get all the data into the txt file.
            for(int i = 0; i < personalData.size(); i++)
            {
            
                out.println(personalData.get(i));
            
            }
            
            System.out.println(fileName + ".txt" + " was created.");
        
        }
     
    }
    
}
