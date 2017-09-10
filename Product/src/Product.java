/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yisroel
 */
public class Product 
{
    
    String name;
    String description;
    private String ID;
    double cost;
    
    public Product (String name, String description, String ID,double cost)
    {
    
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
        
    }
    
    public Product(String CSVRecord) 
    {
        
        String line = CSVRecord;
        String[] recordFile = line.split(",");
        
        this.name = recordFile[0];
        this.description = recordFile[1];
        this.ID = recordFile[2];
        this.cost = Double.parseDouble(recordFile[3].trim());
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    /**
     *
     * @return
     */
    public String toCSVRecord()
    {
       return name + ", " +
               description + ", " +
               ID + ", " + cost;
         
    }
    
    
}
