package views;

import enums.DepartmentEnum;
import java.util.InputMismatchException;
import repository.PatientRepository;

public class CreatePatientView extends ConsoleView {
    private final PatientRepository patientRepository;
    
    public CreatePatientView() {
        this.patientRepository = new PatientRepository();
    }
    
    @Override
    public void show() {        
        System.out.println("--------------CREATE PATIENT FORM--------------");
        // Display a form to create a new patient
        
        System.out.print("NAME: ");
        String name = this.scanner.nextLine(); // Get patient's name from user input
        
        String[] complaints = this.getComplaints(); // Get patient's complaints from user input
        
        this.patientRepository.createPatient(name, complaints); // Create patient in the patient repository
        
        System.out.println("\nSUCCESSFULLY CREATED PATIENT");
        System.out.println("Press ENTER to return to main menu");
        this.scanner.nextLine(); // Wait for user to press ENTER before returning to main menu
    }
    
    private DepartmentEnum getDepartment() {
        System.out.println("---select a department from a following list---");
        for (int i = 0; i < DepartmentEnum.values().length; i++) {
            System.out.println(i+1 + ". " + DepartmentEnum.values()[i].getName()); // Display department names
        }
        System.out.println("Choose one: ");
        
        try {
            DepartmentEnum department = DepartmentEnum.values()[this.scanner.nextInt() - 1]; // Get department choice from user input
            this.scanner.nextLine();
            
            return department;
        } catch (InputMismatchException | IndexOutOfBoundsException exception) {
            System.out.println("\n Invalid input, please input a number"); // Display error message for invalid input
            return this.getDepartment(); // Retry getting department choice
        }
    }
    
    private String[] getComplaints() {
        String department = this.getDepartment().getName(); // Get department name from user input
        
        System.out.println("PATIENT COMPLAINTS (separated by semicolons):");
        String[] complaints = this.scanner.nextLine().split(";"); // Get patient's complaints separated by semicolons
        
        String[] result = new String[complaints.length + 1];
        result[0] = department;
        for (int i = 0; i < complaints.length; i++) {
            result[i+1] = complaints[i].trim(); // Store complaints in an array, trimming leading/trailing spaces
        }
        
        return result;
    }
}
