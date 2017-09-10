import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yisroel
 */
public class Person 
{
   
   private String firstName;
   private String lastName;
   private String title;
   private String ID;
   private int YOB;
   
   Calendar cal = Calendar.getInstance();
   
    /*String firstName
String lastName
String ID  // should never change
String title  // a prefix: Mr. Mrs. Ms, Prof. Dr. Hon. Etc.
int YOB  // Year of birth  // Range should be 1940 - 2000
Additional methods:
public String fullName() // returns firstName, space, lastName
public String formalName() // returns title, space, fullName
 */ 

    public Person(String firstName, String lastName, String title, String ID, int YOB) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.ID = ID;
        this.YOB = YOB;
        
    }

    public Person(String CSVRecord) 
    {
        
        String line = CSVRecord;
        String[] recordFile = line.split(",");
        
        this.firstName = recordFile[0];
        this.lastName = recordFile[1];
        this.title = recordFile[2];
        this.ID = recordFile[3];
        this.YOB = Integer.parseInt(recordFile[4].trim());
        
    }
    
    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getID() 
    {
        return ID;
    }

    public int getYOB() 
    {
        return YOB;
    }
    
    public String fullName()
    {
        return firstName + " " + lastName;
    }
    
    public String formalName()
    {
        return title + " " + firstName + " " + lastName;
    }
    
    public int getAge()
    {
        return YOB - cal.YEAR;
    }
    
    public String toCSVRecord()
    {
       return firstName + ", " +
               lastName + ", " +
               title + ", " +
               ID + ", " +
               YOB;
    }
}
