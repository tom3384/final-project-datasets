
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
        }// end while loop of scanning in the excel CSV to the fields

        // Accepting the user's input for filtering locations by city/zip code.
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("This is a dataset of COVID vaccination locations. Please enter whether you want to filter by city/zip code(enter 'city' or 'zip')"); 
        String userInput = userInputScanner.nextLine();
        System.out.println("You entered: " + userInput);

        System.out.println("Would you like to see all the COVID vaccine brands offered? (Recommended only if filtering by zip, otherwise it will list too many locations.)");
        System.out.println("enter 'y' for yes, or 'n' for no");
        String userInputBrand = userInputScanner.nextLine();
        // Closes the scanner after we're done using it and accepting user input. 
        // userInputScanner.close();

        if (userInputBrand.equals("y")) {
            if (userInput.equals("zip")) {
                System.out.println("Please enter your zip code.");
                String userInputZip = userInputScanner.nextLine();
                System.out.println("This program will now start filtering vaccination locations in your Zip code: " + userInputZip);
                printLocationsByZip(userInputZip);
                return;
                // We return here, so it doesn't repeat the loops below. We could also fix it by entering another else statement to cover the whole code below.
    
                // Prints out the number of the number of vaccination locations in zip
                // System.out.print("The number of vaccination locations in " + userInputZip + " is: ");
                // System.out.println(countCityVaccinationLocationsZip(userInputZip));                
            } else if (userInput.equals("city")) {
                System.out.println("Please enter your city.");
                String userInputCity = userInputScanner.nextLine();
                System.out.println("This program will now start filtering vaccination locations in your City: " + userInputCity);
                printLocationsByCity(userInputCity);
                return;
            }
        } 
     

        // *    Title: Converting Arraylist into HashSet data structure to remove duplicates (because of multiple brands offered).
        // This is because a hashset only allows unique elements. Adding an object to the Hashset automatically checks for duplicates based on the equals and hashCode methods that I put in the VaccineProviderInfo.java file.
        // The original ArrayList data structure is still useful because the duplicates in the csv file are for different COVID vaccine brands, which can be used later for something else if we need to (as long as we do it before converting to HashSet).
        // *    Author: Chatgpt
        // *    Date: 2024
        // *    Availability: http://www.chatgpt.com
        // Convert the ArrayList to a HashSet to remove duplicates
        // I used ChatGPT for these 2 lines of code, as well as the equals and hashNode overrides in VaccineProvider info. We did not learn hashSets in class, so the AI was helpful for me to learn how to use it to remove duplicates.
        Set<VaccineProviderInfo> uniqueRecords = new HashSet<>(records);
        // Convert the HashSet back to an ArrayList
        records = new ArrayList<>(uniqueRecords);

      
        // Code below I wrote using what I learned.
        if (userInput.equals("zip")) {
            System.out.println("Please enter your zip code.");
            String userInputZip = userInputScanner.nextLine();
            System.out.println("This program will now start filtering vaccination locations in your Zip code: " + userInputZip);
            printLocationsByZip(userInputZip);

            // Prints out the number of the number of vaccination locations in zip
            System.out.print("The number of vaccination locations in " + userInputZip + " is: ");
            System.out.println(countCityVaccinationLocationsZip(userInputZip));   
            }       

        // If the user entered city, it will prompt the user to enter their city and will filter locations by their city. 
        if (userInput.equals("city")) {
            System.out.println("Please enter your city.");
            String userInputCity = userInputScanner.nextLine();
            System.out.println("This program will now start filtering vaccination locations in your City: " + userInputCity);
            printLocationsByCity(userInputCity);

        // This can sometimes have extras count because cities might be in other states, like stockton has 2 extra counts for the state of IL. This would require the user to also enter their State, but it's extra input that's not too necessary right now for this project. 
        // Prints out the number of the number of vaccination locations in city (i.e. Stockton)
        System.out.print("The number of vaccination locations is in " + userInputCity + " is: ");
        // System.out.println(countCityVaccinationLocations("Stockton", "CA"));
        System.out.println(countCityVaccinationLocations(userInputCity));
        }

        // Prints out the number of the number of vaccination locations
        System.out.print("The number of total vaccination locations in America is: ");
        System.out.println(countCityVaccinationLocations());

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

    // goes through the whole record to find vaccination locations in a given zip
    public static int countCityVaccinationLocationsZip(String zip)  {
        int count = 0;        

        for (VaccineProviderInfo provider : records) {
            
            String providerZip = provider.getLocAdminZip(); 

            // The substring() method returns a substring from the string, since some of the zip codes in the CSV use the 9 digit zip code.
            // If we do it without null and length, then it will give us error code like: Exception in thread "main" java.lang.StringIndexOutOfBoundsException: Range [0, 5) out of bounds for length 2
            if (providerZip != null && providerZip.length() >= 5 && 
                providerZip.substring(0, 5).equals(zip)) {
                count++;
            }
        }
        return count;
    }
    

    public static int countCityVaccinationLocations(String city)  {
        int count = 0;        
        // goes through the whole record to find vaccination locations in a given city
        for(int i = 0; i < records.size(); i++) {
            // can also use equalsIgnoreCase(city) or set both to toLowerCase
            // .get Returns the element at the specified position in this list.
            if(records.get(i).getLocAdminCity().trim().equalsIgnoreCase(city))
                count++;
        }        
        return count;
    }

    public static void printLocationsByCity(String city) {
        System.out.println("Locations in " + city + ":");
    
        // Convert the city name to lowercase for case-insensitive matching
        // Enhanced for loop, similar to a for loop 
        for (VaccineProviderInfo provider : records) {
            if (provider.getLocAdminCity().equalsIgnoreCase(city)) {
                System.out.println(provider); // Print the provider details
            }
        }
    }

    public static void printLocationsByZip(String zip) {
        System.out.println("Locations in " + zip + ":");
    
        // Convert the city name to lowercase for case-insensitive matching
        // Enhanced for loop, similar to a for loop 
        for (VaccineProviderInfo provider : records) {
            
            // if (provider.getLocAdminZip().equalsIgnoreCase(zip)) {

            String providerZip = provider.getLocAdminZip(); 

            // The substring() method returns a substring from the string.
            if (providerZip != null && providerZip.length() >= 5 && 
                providerZip.substring(0, 5).equals(zip)) {
                System.out.println(provider); // Print the provider details
            }
        }
    }


    // helper method to check if a string is a valid integer
    private static boolean isValidInteger(String value) {
        // checking if the value is null or empty, to return false 
        if (value == null || value.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(value);
            return true;           
        } catch (NumberFormatException e) {
            return false;
            // Thrown to indicate that the application has attempted to convert a string to one of the numeric types, but that the string does not have the appropriate format.
        }
    }

}
