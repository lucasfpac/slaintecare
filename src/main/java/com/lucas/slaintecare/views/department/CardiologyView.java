package com.lucas.slaintecare.views.department;

import com.lucas.slaintecare.entity.Patient;
import com.lucas.slaintecare.enums.DepartmentEnum;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.lucas.slaintecare.views.View;

public class CardiologyView extends DefaultDepartmentView implements View {
    private final Scanner scanner; // Scanner object for user input
    private final Patient patient; // Patient object
    
    public CardiologyView(Patient patient) { // Constructor with Patient object as parameter
        super(patient, DepartmentEnum.Cardiology); // Calls the constructor of the superclass with patient and department
        this.scanner = new Scanner(System.in); // Initializes the Scanner object with System.in
        this.patient = patient; // Assigns the Patient object to the instance variable
    }

    @Override
    public void show() { // Overrides the show() method from the View interface
        if (this.patient.isInpatient()) { // Checks if the patient is an inpatient
            this.showInPatientMenu(); // Calls the showInPatientMenu() method
        } else {
            this.showOutPatientMenu(); // Calls the showOutPatientMenu() method
        }
    }

    private void showInPatientMenu() { // Private method to show the menu for in-patient
        System.out.println("Choose an option");
        System.out.println("1. Have surgery performed");
        System.out.println("2. Prescribe medication");
        System.out.println("3. in-patient discharge");

        if (this.patient.getComplaints().length > 1) { // Checks if the patient has more than one complaint
            System.out.println("4. Transfer to another department");
            System.out.println("5. Back");
        } else {
            System.out.println("4. Back");
        }

        int option;
        try {
            option = this.scanner.nextInt(); // Reads user input for option
            this.scanner.nextLine(); // Consumes the newline character
        } catch (InputMismatchException exception) { // Catches input mismatch exception
            System.out.println("\n Invalid input, please input a number");
            this.show(); // Calls the show() method again to display the menu
            return;
        }

        switch (option) { // Switch case to handle user input
            case 1 -> this.haveSurgery(); // Calls haveSurgery() method
            case 2 -> this.prescribeMedication(); // Calls prescribeMedication() method
            case 3 -> this.dischargeInpatient(); // Calls dischargeInpatient() method
            case 4 -> { // If patient has more than one complaint, calls transferDepartment() method
                if (this.patient.getComplaints().length > 1) this.transferDepartment();
                return;
            }
            case 5 -> { // If patient has only one complaint, show menu again
                if (this.patient.getComplaints().length <= 1) return;
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
            default -> {
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
        }
    }

    private void showOutPatientMenu() { // Private method to show the menu for out-patient
        System.out.println("Choose an option");
        System.out.println("1. Admit as an in-patient");
        System.out.println("2. Transfer to another department");
        System.out.println("3. Prescribe medication");
        System.out.println("4. out-patient discharge");
        System.out.println("5. Back");

        int option;
        try {
            option = this.scanner.nextInt(); // Reads user input for option
            this.scanner.nextLine(); // Consumes the newline character
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number");
            this.show();
            return;
        }
        
        switch (option) {
            case 1 -> this.admitAsAnInpatient(); // If option is 1, call admitAsAnInpatient() method
            case 2 -> this.transferDepartment(); // If option is 2, call transferDepartment() method
            case 3 -> this.prescribeMedication(); // If option is 3, call prescribeMedication() method
            case 4 -> this.outPatientDischarge(); // If option is 4, call outPatientDischarge() method
            case 5 -> {return;} // If option is 5, return from the method
            default -> {
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
        }
    }
}