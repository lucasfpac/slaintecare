package views.department; // Package declaration

import com.lucas.slaintecare.entity.Patient; // Importing required classes
import enums.DepartmentEnum;
import java.util.InputMismatchException;
import java.util.Scanner;
import views.View;

public class OphthalmologyView extends DefaultDepartmentView implements View { // Class declaration, extending "DefaultDepartmentView" class and implementing "View" interface
    private final Scanner scanner; // Instance variable of type Scanner to read input from console
    private final Patient patient; // Instance variable of type Patient to store patient information

    // Constructor for OphthalmologyView class, takes a Patient object as argument
    public OphthalmologyView(Patient patient) {
        super(patient, DepartmentEnum.Ophthalmology); // Calling constructor of superclass "DefaultDepartmentView" with "patient" and "DepartmentEnum.Ophthalmology" as arguments
        this.scanner = new Scanner(System.in); // Initializing scanner object to read input from console
        this.patient = patient; // Setting the patient object
    }

    // Implementation of "show" method from "View" interface
    @Override
    public void show() {
        if (this.patient.isInpatient()) { // Checking if the patient is an in-patient or not
            this.showInPatientMenu(); // If patient is an in-patient, display in-patient menu
        } else {
            this.showOutPatientMenu(); // If patient is an out-patient, display out-patient menu
        }
    }

    // Private method to display in-patient menu
    private void showInPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Have surgery performed");
        System.out.println("2. Prescribe medication");
        System.out.println("3. in-patient discharge");

        if (this.patient.getComplaints().length > 1) { // Checking if patient has more than one complaint
            System.out.println("4. Tranfer to another department");
            System.out.println("5. Back");
        } else {
            System.out.println("4. Back");
        }

        int option;
        try {
            option = this.scanner.nextInt(); // Reading user input as integer
            this.scanner.nextLine(); // Moving scanner to next line
        } catch (InputMismatchException exception) { // Handling input mismatch exception
            System.out.println("\n Invalid input, please input a number");
            this.show(); // Recursively calling show method to display menu again
            return;
        }

        // Using switch statement to perform action based on user input
        switch (option) {
            case 1 -> this.haveSurgery(); // If user inputs 1, call haveSurgery method
            case 2 -> this.prescribeMedication(); // If user inputs 2, call prescribeMedication method
            case 3 -> this.dischargeInpatient(); // If user inputs 3, call dischargeInpatient method
            case 4 -> {
                if (this.patient.getComplaints().length > 1) this.transferDepartment(); // If user inputs 4 and patient has more than one complaint, call transferDepartment method
                return;
            }
            case 5 -> {
                if (this.patient.getComplaints().length <= 1) return; // If user inputs 5 and patient has only one complaint, return
                throw new AssertionError(); // If user inputs 5 and patient has more than one complaint, throw AssertionError
            }
            default -> throw new AssertionError(); // Throw AssertionError for any other user input
        }
    }
    private void showOutPatientMenu() {
        // Displaying menu options
        System.out.println("Choose an option");
        System.out.println("1. Admit as an in-patient");
        System.out.println("2. Transfer to another department");
        System.out.println("3. Prescribe medication");
        System.out.println("4. Out-patient discharge");
        System.out.println("5. Back");
        
        int option;
        try {
            // Reading user input for option
            option = this.scanner.nextInt();
            this.scanner.nextLine();
        } catch (InputMismatchException exception) {
            // Handling input mismatch exception
            System.out.println("\n Invalid input, please input a number");
            this.show();
            return;
        }
        
        // Processing user input using a switch statement
        switch (option) {
            case 1 -> this.admitAsAnInpatient(); // If user chooses option 1, call admitAsAnInpatient() method
            case 2 -> this.transferDepartment(); // If user chooses option 2, call transferDepartment() method
            case 3 -> this.prescribeMedication(); // If user chooses option 3, call prescribeMedication() method
            case 4 -> this.outPatientDischarge(); // If user chooses option 4, call outPatientDischarge() method
            case 5 -> {return;} // If user chooses option 5, return without performing any action
            default -> throw new AssertionError(); // Throw an AssertionError if user chooses an invalid option
        }
    }
}    
