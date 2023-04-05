package views.department;

import com.lucas.slaintecare.entity.Patient;
import enums.DepartmentEnum;
import java.util.InputMismatchException;
import java.util.Scanner;
import views.View;

public class RadiologyView extends DefaultDepartmentView implements View {
    private final Scanner scanner;
    private final Patient patient;
    
    public RadiologyView(Patient patient) {
        super(patient, DepartmentEnum.Radiology);
        this.scanner = new Scanner(System.in);
        this.patient = patient;
    }
    
    @Override
    public void show() {
        if (this.patient.isInpatient()) {
            this.showInPatientMenu();
        } else {
            this.showOutPatientMenu();
        }
    }
    
    // Method to display the menu for in-patients in the Radiology department
    private void showInPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Transfer to another department");
        System.out.println("2. Back");
        
        int option;
        try {
            option = this.scanner.nextInt(); // Read user input as integer
            this.scanner.nextLine(); // Consume the newline character
        } catch (InputMismatchException exception) {
            System.out.println("\nInvalid input, please input a number");
            this.show(); // Recursive call to show() method to display menu again
            return;
        }
        
        switch (option) {
            case 1 -> this.transferDepartment(); // Call transferDepartment() method to transfer patient to another department
            case 2 -> {return;} // Return from the method to go back
            default -> throw new AssertionError(); // Throw an exception for unexpected input
        }
    }
    
    // Method to display the menu for out-patients in the Radiology department
    private void showOutPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Transfer to another department");
        System.out.println("2. Out-patient discharge");
        System.out.println("3. Back");
        
        int option;
        try {
            option = this.scanner.nextInt(); // Read user input as integer
            this.scanner.nextLine(); // Consume the newline character
        } catch (InputMismatchException exception) {
            System.out.println("\nInvalid input, please input a number");
            this.show(); // Recursive call to show() method to display menu again
            return;
        }
        
        switch (option) {
            case 1 -> this.transferDepartment(); // Call transferDepartment() method to transfer patient to another department
            case 2 -> this.outPatientDischarge(); // Call outPatientDischarge() method to discharge patient from the department
            case 3 -> {return;} // Return from the method to go back
            default -> throw new AssertionError(); // Throw an exception for unexpected input
        }
    }
}
