package views.department;

import com.lucas.slaintecare.entity.Patient;
import enums.DepartmentEnum;
import java.util.InputMismatchException;
import java.util.Scanner;
import views.View;

public class OBGYNView extends DefaultDepartmentView implements View {
    private final Scanner scanner; // Scanner object for reading user input
    private final Patient patient; // Patient object associated with the view
    
    public OBGYNView(Patient patient) {
        super(patient, DepartmentEnum.OB_GYN);
        this.scanner = new Scanner(System.in);
        this.patient = patient;
    }
    
    @Override
    public void show() {
        if (this.patient.isInpatient()) {
            this.showInPatientMenu(); // Show in-patient menu if patient is admitted
        } else {
            this.showOutPatientMenu(); // Show out-patient menu if patient is not admitted
        }
    }
    
    private void showInPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Have surgery performed");
        System.out.println("2. Prescribe medication");
        System.out.println("3. In-patient discharge");
        
        // Check if patient has more than one complaint, show additional options
        if (this.patient.getComplaints().length > 1) {
            System.out.println("4. Transfer to another department");
            System.out.println("5. Back");
        } else {
            System.out.println("4. Back");
        }
        
        int option;
        try {
            option = this.scanner.nextInt(); // Read user input
            this.scanner.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number");
            this.show(); // Show menu again on invalid input
            return;
        }
        
        // Perform action based on user input
        switch (option) {
            case 1 -> this.haveSurgery(); // Option 1: Have surgery performed
            case 2 -> this.prescribeMedication(); // Option 2: Prescribe medication
            case 3 -> this.dischargeInpatient(); // Option 3: In-patient discharge
            case 4 -> {
                if (this.patient.getComplaints().length > 1) this.transferDepartment(); // Option 4: Transfer to another department
                return;
            }
            case 5 -> {
                if (this.patient.getComplaints().length <= 1) return; // Option 5: Back (if patient has only one complaint)
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
            default -> {
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
        }
    }
    
    private void showOutPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Admit as an in-patient");
        System.out.println("2. Transfer to another department");
        System.out.println("3. Prescribe medication");
        System.out.println("4. Out-patient discharge");
        System.out.println("5. Back");
        
        int option;
        try {
            option = this.scanner.nextInt(); // Read user input
            this.scanner.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number");
            this.show(); // Show menu again on invalid input
            return;
        }
        
        // Perform action based on user input
        switch (option) {
            case 1 -> this.admitAsAnInpatient(); // If option is 1, call the admitAsAnInpatient() method
            case 2 -> this.transferDepartment(); // If option is 2, call the transferDepartment() method
            case 3 -> this.prescribeMedication(); // If option is 3, call the prescribeMedication() method
            case 4 -> this.outPatientDischarge(); // If option is 4, call the outPatientDischarge() method
            case 5 -> {return;} // If option is 5, return from the current method
            default -> {
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
        }
    }
}
