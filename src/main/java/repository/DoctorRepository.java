package repository;

import com.lucas.slaintecare.entity.Doctor;
import enums.DepartmentEnum;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import utils.CsvReader;

public class DoctorRepository {
    private final List<Doctor> doctorList; // List to store Doctor objects
    private final String INFO_FILE = "resources/Sláintecare Doctor Info.csv"; // File path for doctor information CSV file
    
    public DoctorRepository() {
        this.doctorList = new ArrayList<>(); // Initialize doctorList as an empty ArrayList
        this.loadDoctors(); // Load doctors from CSV file during object instantiation
    }
    
    private void loadDoctors() {
        try {
            List<List<String>> records = CsvReader.readCSV(INFO_FILE, ","); // Read CSV file using CsvReader utility
            records.stream().forEach(record -> { // Process each record in the CSV file
                String name = record.get(0); // Extract doctor name from CSV record
                String department = record.get(1); // Extract department name from CSV record
                String speciality = record.get(2); // Extract speciality from CSV record
                Boolean surgeon = record.get(3).equalsIgnoreCase("yes"); // Extract surgeon status from CSV record
                Boolean onDuty = record.get(4).equalsIgnoreCase("yes"); // Extract on-duty status from CSV record
                
                this.doctorList.add(new Doctor(name, this.getDepartment(department), speciality, surgeon, onDuty)); // Create Doctor object and add to doctorList
            });
        } catch (FileNotFoundException exception) {
            // Exception handling for file not found
        }
    }
    
    private DepartmentEnum getDepartment(String departmentName) {
        DepartmentEnum result = null; // Initialize result as null
        for (DepartmentEnum department : DepartmentEnum.values()) { // Loop through all department enums
            if (department.getName().equals(departmentName)) { // Check if department name matches the given departmentName
                result = department; // Set result to matched department
                break; // Exit loop once match is found
            }
        }
        
        return result; // Return the matched DepartmentEnum value, or null if no match found
    }
    
    public List<Doctor> getDoctors() {        
        return this.doctorList; // Return the list of loaded Doctor objects
    }
}