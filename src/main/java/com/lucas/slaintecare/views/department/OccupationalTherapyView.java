package com.lucas.slaintecare.views.department;

import com.lucas.slaintecare.entity.Patient;
import com.lucas.slaintecare.enums.DepartmentEnum;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.lucas.slaintecare.views.View;

public class OccupationalTherapyView extends DefaultDepartmentView implements View {
    private final Scanner scanner;
    private final Patient patient;

    // Constructor for OccupationalTherapyView, takes in a Patient object as input
    public OccupationalTherapyView(Patient patient) {
        // Call the constructor of the superclass DefaultDepartmentView with patient and department type as parameters
        super(patient, DepartmentEnum.OccupationalTherapy);
        this.scanner = new Scanner(System.in);
        this.patient = patient;
    }

    @Override
    public void show() {
        if (this.patient.isInpatient()) {
            this.showInPatientMenu(); // If patient is an inpatient, show the inpatient menu
        } else {
            this.showOutPatientMenu(); // If patient is an outpatient, show the outpatient menu
        }
    }

    private void showInPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Prescribe medication");
        System.out.println("2. in-patient discharge");
        System.out.println("3. Back");

        int option;
        try {
            option = this.scanner.nextInt(); // Read user input as an integer
            this.scanner.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number"); // Catch input mismatch exception if non-integer input is provided
            this.show();
            return;
        }

        // Use a switch statement to handle user input
        switch (option) {
            case 1 -> this.prescribeMedication(); // If option 1 is chosen, call prescribeMedication() method
            case 2 -> this.dischargeInpatient(); // If option 2 is chosen, call dischargeInpatient() method
            case 3 -> {return;} // If option 3 is chosen, return from the method
            default -> {
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
        }
    }

    private void showOutPatientMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Prescribe medication");
        System.out.println("2. out-patient discharge");
        System.out.println("3. Back");

        int option;
        try {
            option = this.scanner.nextInt(); // Read user input as an integer
            this.scanner.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number"); // Catch input mismatch exception if non-integer input is provided
            this.show();
            return;
        }

        // Use a switch statement to handle user input
        switch (option) {
            case 1 -> this.prescribeMedication(); // If option 1 is chosen, call prescribeMedication() method
            case 2 -> this.outPatientDischarge(); // If option 2 is chosen, call outPatientDischarge() method
            case 3 -> {return;} // If option 3 is chosen, return from the method
            default -> {
                System.out.println("\n Invalid input, please input a number"); // show menu again for invalid input
                this.show(); // Calls the show() method again to display the menu
            }
        }
    }
}
