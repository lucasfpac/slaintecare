package views.department;

import com.lucas.slaintecare.entity.Patient;
import enums.DepartmentEnum;
import java.util.InputMismatchException;
import java.util.Scanner;
import views.View;

public class RheumatologyView extends DefaultDepartmentView implements View {
    private final Scanner scanner; // Scanner object for reading user input
    private final Patient patient; // Patient object associated with the view
    
    public RheumatologyView(Patient patient) {
        super(patient, DepartmentEnum.Rheumatology); // Call to superclass constructor
        this.scanner = new Scanner(System.in); // Initialize scanner
        this.patient = patient; // Set patient object
    }
    
    @Override
    public void show() {
        if (this.patient.isInpatient()) {
            this.showInPatientMenu(); // Show in-patient menu if patient is an in-patient
        } else {
            this.showOutPatientMenu(); // Show out-patient menu if patient is an out-patient
        }
    }
    
    private void showInPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Prescribe medication");
        System.out.println("2. in-patient discharge");
        System.out.println("3. Back");
        
        int option;
        try {
            option = this.scanner.nextInt(); // Read user input as integer
            this.scanner.nextLine(); // Consume newline character
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number");
            this.show(); // Show the menu again in case of invalid input
            return;
        }
        
        switch (option) {
            case 1 -> this.prescribeMedication(); // Call prescribeMedication() method for option 1
            case 2 -> this.dischargeInpatient(); // Call dischargeInpatient() method for option 2
            case 3 -> {return;} // Return from method for option 3
            default -> {
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
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
            this.scanner.nextLine(); // Consume newline character
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number");
            this.show(); // Show the menu again in case of invalid input
            return;
        }
        
        switch (option) {
            case 1 -> this.admitAsAnInpatient(); // Call admitAsAnInpatient() method for option 1
            case 2 -> this.prescribeMedication(); // Call prescribeMedication() method for option 2
            case 3 -> this.outPatientDischarge(); // Call outPatientDischarge() method for option 3
            case 4 -> {return;} // Return from method for option 4
            default -> {
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
        }
    }
}
