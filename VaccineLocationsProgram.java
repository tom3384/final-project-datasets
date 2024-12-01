
// Tom Nguyen
// 11/29/24
// CPSC 39 project

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VaccineLocationsProgram {
    //arraylist
    // Code from class notes and previous assignment
	public static ArrayList<VaccineProviderInfo> records = new ArrayList<VaccineProviderInfo>();


	public static void main(String[] args) {
		//read in our data and create this records Arraylist
		//read in our data and put it in an arraylist
		Scanner input = null;
		// Reads in the Vaccines.gov__COVID-19_vaccinating_provider_locations
		try {
			input = new Scanner(new File("Vaccines.gov__COVID-19_vaccinating_provider_locations.csv"));
		} catch (FileNotFoundException e) {
			//file not found. Signals that an attempt to open the file denoted by a specified pathname has failed.
			System.out.println("file not found");
            // printStackTrace() helps the programmer to understand where the actual problem occurred. It helps to trace the exception.
			e.printStackTrace();
		}

		//reading in the header
		input.nextLine();

        // Code to parse through the file 
        while(input.hasNext()) {
            String record = input.nextLine();
            // Splits up with a comma because that is what we do with CSV files. 
            String[] fields = record.split(",");         

            // Debugging to see if parsing cities, but this prints all the cities. Maybe have to set .equals
            // String city = fields[6];
            // System.out.println("Parsed city: " + city);

            // Validate and parse latitude and longitude
            // double latitude = isValidDouble(fields[26]) ? Double.parseDouble(fields[26]) : 0.0;
            // double longitude = isValidDouble(fields[27]) ? Double.parseDouble(fields[27]) : 0.0;


            records.add(new VaccineProviderInfo(
                fields[0],   // providerLocationGuid (Field 0)
                fields[1],   // locStoreNo (Field 1)
                fields[2],   // locPhone (Field 2)
                fields[3],   // locName (Field 3)
                fields[4],   // locAdminStreet1 (Field 4)
                fields[5],   // locAdminStreet2 (Field 5)
                fields[6],   // locAdminCity (Field 6)
                fields[7],   // locAdminState (Field 7)
                fields[8],   // locAdminZip (Field 8)
                fields[9],   // sundayHours (Field 9)
                fields[10],  // mondayHours (Field 10)
                fields[11],  // tuesdayHours (Field 11)
                fields[12],  // wednesdayHours (Field 12)
                fields[13],  // thursdayHours (Field 13)
                fields[14],  // fridayHours (Field 14)
                fields[15],  // saturdayHours (Field 15)
                fields[16],  // webAddress (Field 16)
                fields[17],  // preScreen (Field 17)
                fields[18],  // insuranceAccepted (Field 18)
                fields[19],  // walkinsAccepted (Field 19)
                fields[20],  // providerNotes (Field 20)
                fields[21],  // ndc (Field 21)
                fields[22],  // medName (Field 22)
                Boolean.parseBoolean(fields[23]), // inStock (Field 23) - parsed as boolean
                fields[24],  // supplyLevel (Field 24)
                fields[25],  // quantityLastUpdated (Field 25)
                fields[26],  // latitude (Field 26) - comes up with a bug if parsed as double, 
                             // double bug maybe because latitude/longitude at the top of the CSV is not a double
                             // might have to use isValidDouble if we use it as a Double  
                fields[27],  // longitude (Field 27) - comes up with a bug if parsed as double
                fields[28],  // category (Field 28)
                fields[29],  // unnamedColumn (Field 29)
                Boolean.parseBoolean(fields[30]), // offersFreeMasks (Field 30) - parsed as boolean
                isValidInteger(fields[31]) ? Integer.parseInt(fields[31]) : 0, // minAgeMonths. 
                // a ternary operator. It works as a concise way to make a decision, similar to an if-else statement. 
                // checks if isValidInteger(fields[31]) is true (can be parsed as integer), if true, then the code after ? is executed. otherwise, if false and cannot be parsed as integer, then it returns a 0
                isValidInteger(fields[32]) ? Integer.parseInt(fields[32]) : 0, // minAgeYears
                Boolean.parseBoolean(fields[33])  // bridgeAccessProgram (Field 33) - parsed as boolean
            ));			
        }// end while loop of scanning in the excel to the fields



        // *    Title: Converting Arraylist into HashSet data structure to remove duplicates. This is because a hashset only allows unique elements. Adding an object to the Hashset automatically checks for duplicates based on the equals and hashCode methods that I put in the VaccineProviderInfo.java file.
        // The original ArrayList data structure is still useful because the duplicates in the csv file are for different COVID vaccine brands, which can be used later for something else if we need to (as long as we do it before converting to HashSet).
        // *    Author: Chatgpt
        // *    Date: 2024
        // *    Availability: http://www.chatgpt.com
        // Convert the ArrayList to a HashSet to remove duplicates
        Set<VaccineProviderInfo> uniqueRecords = new HashSet<>(records);
        // Convert the HashSet back to an ArrayList
        records = new ArrayList<>(uniqueRecords);

        
        // System.out.println("Unique records count: " + records.size());

        // Prints out the number of the number of vaccination locations
        System.out.print("The number of vaccination locations is: ");
        System.out.println(countCityVaccinationLocations());

        // Prints out the number of the number of vaccination locations in Stockton 
        System.out.print("The number of vaccination locations is in Stockton, CA is: ");
        System.out.println(countCityVaccinationLocations("Stockton", "CA"));


        // for (VaccineProviderInfo provider : records) {
        //     System.out.println(provider.getLocStoreNo() + ": " + provider.getLocPhone());
        // }






    }// end main 


    // It seems it counts 253136 locations, which matches up with the excel file 
    // returns the number of vaccination locations in the data set 
    public static int countCityVaccinationLocations()  {
        int count = 0;        
        // goes through the whole record to find vaccination locations
        for(int i = 0; i < records.size(); i++) {
            count++;
        }        
        return count;
    }

    // returns the number of vaccination locations in a specified city (file is currently set for COVID vaccination location datasets)
    // Adding the state accounts for if there's cities in other states (for example, there were 2 cities of Stockton in IL), we could account for this by doing another && records.get(i).getLocAdminState().equalsIgnoreCase(state)
    // Counts 105 locations before including the state, and 102 locations after specifying the state, which matches up. However, the count is still off a bit, I checked the csv file to make sure that there were no empty spaces or anything. Not sure why, or maybe I'm misreading the csv file. Should be maybe 138 count? I made sure to set it to equalsIgnoreCase... 
    // .trim to remove any whitespace that the creators might have accidentally added in the csv 
    public static int countCityVaccinationLocations(String city, String state)  {
        int count = 0;        
        // goes through the whole record to find vaccination locations in a given city
        for(int i = 0; i < records.size(); i++) {
            // can also use equalsIgnoreCase(city) or set both to toLowerCase
            // .get Returns the element at the specified position in this list.
            if(records.get(i).getLocAdminCity().trim().equalsIgnoreCase(city) && records.get(i).getLocAdminState().equalsIgnoreCase(state))
                count++;

            // String normalizedCity = records.get(i).getLocAdminCity().replaceAll("\\s+", " ").trim();
            // if (normalizedCity.equalsIgnoreCase(city)) 
            // debugging, this doesn't help the count either, which says that there might not be any special or hidden characters 
            // also doesnt take into account the states 
        }        
        return count;
    }

    

    //  private static boolean isValidDouble(String value) {
    //      if (value == null || value.isEmpty()) {
    //          return false;
    //      }
    //      try {
    //          Double.parseDouble(value);
    //          return true;
    //      } catch (NumberFormatException e) {
    //          return false;
    //      }
    //  }
    
    // helper method to check if a string is a valid integer
    private static boolean isValidInteger(String value) {
        // checking if the value is null or empty, to return false 
        if (value == null || value.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(value);
            return true;

        // Thrown to indicate that the application has attempted to convert a string to one of the numeric types, but that the string does not have the appropriate format.
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
