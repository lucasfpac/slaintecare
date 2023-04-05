package views.department;

import com.lucas.slaintecare.entity.Patient;
import enums.DepartmentEnum;
import java.util.InputMismatchException;
import java.util.Scanner;
import views.View;

public class OncologyView extends DefaultDepartmentView implements View {
    private final Scanner scanner;
    private final Patient patient;
    
    public OncologyView(Patient patient) {
        super(patient, DepartmentEnum.Oncology);
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
    
    private void showInPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Have surgery performed");
        System.out.println("2. Prescribe medication");
        System.out.println("3. in-patient discharge");
        
        // If the patient has more than 1 complaint, show additional options
        if (this.patient.getComplaints().length > 1) {
            System.out.println("4. Tranfer to another department");
            System.out.println("5. Back");
        } else {
            System.out.println("4. Back");
        }
        
        int option;
        try {
            option = this.scanner.nextInt();
            this.scanner.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number");
            this.show();
            return;
        }
        
        // Process user input based on selected option
        switch (option) {
            case 1 -> this.haveSurgery();
            case 2 -> this.prescribeMedication();
            case 3 -> this.dischargeInpatient();
            case 4 -> {
                // If the patient has more than 1 complaint, allow transfer to another department
                if (this.patient.getComplaints().length > 1) this.transferDepartment();
                return;
            }
            case 5 -> {
                // If the patient has 1 or fewer complaints, return to previous menu
                if (this.patient.getComplaints().length <= 1) return;
                throw new AssertionError(); // Throw an error for invalid input
            }
            default -> throw new AssertionError(); // Throw an error for invalid input
        }
    }
    
    private void showOutPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Admit as an in-patient");
        System.out.println("2. Tranfer to another department");
        System.out.println("3. Prescribe medication");
        System.out.println("4. out-patient discharge");
        System.out.println("5. Back");
        
        int option;
        try {
            option = this.scanner.nextInt();
            this.scanner.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number");
            this.show();
            return;
        }
        
        // Process user input based on selected option
        switch (option) {
            case 1 -> this.admitAsAnInpatient();
            case 2 -> this.transferDepartment();
            case 3 -> this.prescribeMedication();
            case 4 -> this.outPatientDischarge();
            case 5 -> {return;} // Return to previous menu
            default -> throw new AssertionError(); // Throw an error for invalid input
        }
    }
}
