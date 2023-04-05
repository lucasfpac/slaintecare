package views.department;

import com.lucas.slaintecare.entity.Patient;
import enums.DepartmentEnum;
import java.util.InputMismatchException;
import java.util.Scanner;
import views.View;

public class ENTView extends DefaultDepartmentView implements View {
    private final Scanner scanner; // Scanner object for reading user input
    private final Patient patient; // Patient object associated with this view
    
    public ENTView(Patient patient) {
        super(patient, DepartmentEnum.ENT); // Call the constructor of the superclass
        this.scanner = new Scanner(System.in); // Initialize the Scanner object
        this.patient = patient; // Assign the Patient object
    }
    
    @Override
    public void show() {
        if (this.patient.isInpatient()) { // Check if the patient is an in-patient
            this.showInPatientMenu(); // Show the in-patient menu
        } else {
            this.showOutPatientMenu(); // Show the out-patient menu
        }
    }
    
    private void showInPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Have surgery performed");
        System.out.println("2. Prescribe medication");
        System.out.println("3. in-patient discharge");
        System.out.println("4. Back");
        
        int option;
        try {
            option = this.scanner.nextInt(); // Read user input as integer
            this.scanner.nextLine(); // Consume the newline character
        } catch (InputMismatchException exception) { // Catch input mismatch exceptions
            System.out.println("\n Invalid input, please input a number");
            this.show(); // Show the menu again
            return;
        }
        
        switch (option) {
            case 1 -> this.haveSurgery(); // Call haveSurgery() method if option is 1
            case 2 -> this.prescribeMedication(); // Call prescribeMedication() method if option is 2
            case 3 -> this.dischargeInpatient(); // Call dischargeInpatient() method if option is 3
            case 4 -> {return;} // Return from the method if option is 4
            default -> throw new AssertionError(); // Throw an AssertionError for unexpected options
        }
    }
    
    private void showOutPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Admit as an in-patient");
        System.out.println("2. Prescribe medication");
        System.out.println("3. out-patient discharge");
        System.out.println("4. Back");
        
        int option;
        try {
            option = this.scanner.nextInt(); // Read user input as integer
            this.scanner.nextLine(); // Consume the newline character
        } catch (InputMismatchException exception) { // Catch input mismatch exceptions
            System.out.println("\n Invalid input, please input a number");
            this.show(); // Show the menu again
            return;
        }
        
        switch (option) {
            case 1 -> this.admitAsAnInpatient(); // Call admitAsAnInpatient() method if option is 1
            case 2 -> this.transferDepartment(); // Call transferDepartment() method if option is 2
            case 3 -> this.prescribeMedication(); // Call prescribeMedication() method if option is 3
            case 4 -> {return;} // Return from the method if option is 4
            default -> throw new AssertionError(); // Throw an AssertionError for unexpected options
        }
    }
}
