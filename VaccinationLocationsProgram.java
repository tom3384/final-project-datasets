
// Tom Nguyen
// 11/29/24
// CPSC 39 project

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VaccineLocationsProgram {
    //arraylist
	public static ArrayList<VaccineProviderInfo> records = new ArrayList<VaccineProviderInfo>();

	public static void main(String[] args) {
		//read in our data and create this records Arraylist
		//read in our data and put it in an arraylist
		Scanner input = null;
		// Reads in the Vaccines.gov__COVID-19_vaccinating_provider_locations
		try {
			input = new Scanner(new File("Vaccines.gov__COVID-19_vaccinating_provider_locations.csv"));
		} catch (FileNotFoundException e) {
			//file not found
			System.out.println("file not found");
			e.printStackTrace();
		}

		//reading in the header
		input.nextLine();

        // Code to parse through the file 
        while(input.hasNext()) {
            String record = input.nextLine();
            // Splits up with a comma because that is what we do with CSV files. 
            String[] fields = record.split(",");         

            // Validate and parse latitude and longitude
            double latitude = isValidDouble(fields[26]) ? Double.parseDouble(fields[26]) : 0.0;
            double longitude = isValidDouble(fields[27]) ? Double.parseDouble(fields[27]) : 0.0;

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
                Double.parseDouble(fields[26]),  // latitude (Field 26) - parsed as double
                Double.parseDouble(fields[27]),  // longitude (Field 27) - parsed as double
                fields[28],  // category (Field 28)
                fields[29],  // unnamedColumn (Field 29)
                Boolean.parseBoolean(fields[30]), // offersFreeMasks (Field 30) - parsed as boolean
                Integer.parseInt(fields[31]),     // minAgeMonths (Field 31) - parsed as integer
                Integer.parseInt(fields[32]),     // minAgeYears (Field 32) - parsed as integer
                Boolean.parseBoolean(fields[33])  // bridgeAccessProgram (Field 33) - parsed as boolean
            ));			
        }// end while loop of scanning in the excel to the fields

        // Prints out the number of the number of vaccination locations
        System.out.print("The number of vaccination locations is: ");
        System.out.println(countCityVaccinationLocations());
        // Prints out the number of the number of vaccination locations in Stockton 
        System.out.print("The number of vaccination locations is in Stockton is: ");
        System.out.println(countCityVaccinationLocations("Stockton"));

        // for (VaccineProviderInfo provider : records) {
        //     System.out.println(provider.getLocStoreNo() + ": " + provider.getLocPhone());
        // }






    }// end main 




    public static int countCityVaccinationLocations()  {
        int count = 0;        
        // goes through the whole record to find vaccination locations
        for(int i = 0; i < records.size(); i++) {
            count++;
        }        
        return count;
    }

    public static int countCityVaccinationLocations(String loc_admin_city)  {
        int count = 0;        
        // goes through the whole record to find vaccination locations in a given city
        for(int i = 0; i < records.size(); i++) {
            count++;
        }        
        return count;
    }

     private static boolean isValidDouble(String value) {
         if (value == null || value.isEmpty()) {
             return false;
         }
         try {
             Double.parseDouble(value);
             return true;
         } catch (NumberFormatException e) {
             return false;
         }
     }
    

}
