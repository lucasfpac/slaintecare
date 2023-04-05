package views.department;

import com.lucas.slaintecare.entity.Patient;
import enums.DepartmentEnum;
import java.util.InputMismatchException;
import java.util.Scanner;
import views.View;

public class EmergencyView extends DefaultDepartmentView implements View {
    private final Scanner scanner;
    private final Patient patient;

    public EmergencyView(Patient patient) {
        super(patient, DepartmentEnum.Emergency);
        this.scanner = new Scanner(System.in);
        this.patient = patient;
    }

    @Override
    public void show() {
        // Displays appropriate menu based on patient's inpatient/outpatient status
        if (this.patient.isInpatient()) {
            this.showInPatientMenu();
        } else {
            this.showOutPatientMenu();
        }
    }

    // Displays menu options for in-patient
    private void showInPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Have surgery performed");
        System.out.println("2. Prescribe medication");
        System.out.println("3. in-patient discharge");

        // Displays additional options if patient has complaints
        if (this.patient.getComplaints().length > 1) {
            System.out.println("4. Transfer to another department");
            System.out.println("5. Back");
        } else {
            System.out.println("4. Back");
        }

        int option;
        try {
            // Reads and stores user input
            option = this.scanner.nextInt();
            this.scanner.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number");
            // Recursively calls show() to display menu again on invalid input
            this.show();
            return;
        }

        // Performs action based on user input
        switch (option) {
            case 1 -> this.haveSurgery(); // Calls haveSurgery() method
            case 2 -> this.prescribeMedication(); // Calls prescribeMedication() method
            case 3 -> this.dischargeInpatient(); // Calls dischargeInpatient() method
            case 4 -> {
                if (this.patient.getComplaints().length > 1)
                    this.transferDepartment(); // Calls transferDepartment() method if patient has complaints
                return;
            }
            case 5 -> {
                if (this.patient.getComplaints().length <= 1)
                    return; // Returns to previous menu if patient does not have complaints
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
            default -> {
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
        }
    }

    // Displays menu options for out-patient
    private void showOutPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Admit as an in-patient");
        System.out.println("2. Transfer to another department");
        System.out.println("3. Prescribe medication");
        System.out.println("4. out-patient discharge");
        System.out.println("5. Back");

        int option;
        try {
            // Reads and stores user input
            option = this.scanner.nextInt();
            this.scanner.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number");
            // Recursively calls show() to display menu again on invalid input
            this.show();
            return;
        }

        // Performs action based on user input
        switch (option) {
            case 1 -> this.admitAsAnInpatient(); // If option is 1, call the admitAsAnInpatient() method
            case 2 -> this.transferDepartment(); // If option is 2, call the transferDepartment() method
            case 3 -> this.prescribeMedication(); // If option is 3, call the prescribeMedication() method
            case 4 -> this.outPatientDischarge(); // If option is 4, call the outPatientDischarge() method
            case 5 -> {return;} // If option is 5, return without doing anything
            default -> {
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
        }
    }   
}