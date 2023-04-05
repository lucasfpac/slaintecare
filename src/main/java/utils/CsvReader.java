package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {
    // Method to read CSV file and return a list of lists containing CSV records
    public static List<List<String>> readCSV(String filename, String delimiter) throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>(); // Create a list to store CSV records
        Scanner scanner = new Scanner(new File(filename), "UTF-8"); // Create a Scanner object to read the CSV file
        scanner.nextLine(); // Skip the first line (header) of the CSV file
        while(scanner.hasNextLine()) { // Loop through each line in the CSV file
            records.add(CsvReader.getRecordFromLine(scanner.nextLine(), delimiter)); // Parse each line and add it to the list of records
        }
        return records; // Return the list of lists containing CSV records
    }
    
    // Method to parse a line from CSV and return a list of values
    public static List<String> getRecordFromLine(String line, String delimiter) {
        List<String> values = new ArrayList<>(); // Create a list to store values from a CSV line
        Scanner scanner = new Scanner(line); // Create a Scanner object to read the line
        scanner.useDelimiter(delimiter); // Set the delimiter for parsing the line
        while(scanner.hasNext()) { // Loop through each value in the line
            values.add(scanner.next()); // Add each value to the list of values
        }
        return values; // Return the list of values from the CSV line
    }
}