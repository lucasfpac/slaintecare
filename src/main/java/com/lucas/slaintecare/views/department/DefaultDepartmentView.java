package com.lucas.slaintecare.views.department;

import com.lucas.slaintecare.entity.Patient;
import com.lucas.slaintecare.enums.DepartmentEnum;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.lucas.slaintecare.repository.PatientRepository;

public class DefaultDepartmentView {
    private final Scanner scanner; // Scanner object to read user input
    private final Patient patient; // Patient object associated with the view
    private final DepartmentEnum department; // DepartmentEnum associated with the view
    private final PatientRepository patientRepository; // PatientRepository object to manage patient data

    public DefaultDepartmentView(Patient patient, DepartmentEnum department) {
        this.scanner = new Scanner(System.in); // Initialize the scanner to read from System.in
        this.patientRepository = new PatientRepository(); // Initialize the patient repository

        this.patient = patient; // Set the patient associated with the view
        this.department = department; // Set the department associated with the view
    }

    protected void transferDepartment() {
        System.out.println("---select a department from a following list---"); // Display prompt for selecting a department
        for (int i = 0; i < DepartmentEnum.values().length; i++) {
            System.out.println(i + 1 + ". " + DepartmentEnum.values()[i].getName()); // Display department options
        }
        System.out.println("Choose one: "); // Display prompt to choose a department

        try {
            DepartmentEnum department = DepartmentEnum.values()[this.scanner.nextInt() - 1]; // Read user input for department choice
            this.scanner.nextLine(); // Consume the newline character left in the scanner buffer

            this.patient.transferDepartment(department.getName()); // Call the transferDepartment method on the associated patient
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException exception) {
            System.out.println("\n Invalid input, please input a number"); // Display error message for invalid input
            this.transferDepartment(); // Call the transferDepartment method again for valid input
        }
    }

    protected void haveSurgery() {
        System.out.println("---select a speciality from a following list---"); // Display prompt for selecting a specialty

        List<DepartmentEnum> specialities = List.of(DepartmentEnum.values()) // Create a list of specialities from DepartmentEnum values
                .stream()
                .filter(department -> department.isCanHaveOperations()) // Filter specialities that can have operations
                .collect(Collectors.toList()); // Collect the filtered specialities into a list

        for (int i = 0; i < specialities.size(); i++) {
            System.out.println(i + 1 + ". " + specialities.get(i).getName()); // Display specialty options
        }
        System.out.println("Choose one: "); // Display prompt to choose a specialty

        try {
            DepartmentEnum speciality = specialities.get(this.scanner.nextInt() - 1); // Read user input for specialty choice
            this.scanner.nextLine(); // Consume the newline character left in the scanner buffer

            this.patient.haveSurgery(speciality.getName()); // Call the haveSurgery method on the associated patient
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException exception) {
            System.out.println("\n Invalid input, please input a number"); // Display error message for invalid input
            this.haveSurgery(); // Call the haveSurgery method again for valid input
        }
    }

    protected void prescribeMedication() {
        System.out.println("---select a speciality from a following list---");// Display prompt for selecting a specialty
    
        // Create a list of specialities from the DepartmentEnum values
        List<DepartmentEnum> specialities = List.of(DepartmentEnum.values());
    
        // Print the list of specialities
        for (int i = 0; i < specialities.size(); i++) {
            System.out.println(i+1 + ". " + specialities.get(i).getName());
        }
        System.out.println("Choose one: ");
    
        try {
            // Read user input and get the selected speciality
            DepartmentEnum speciality = specialities.get(this.scanner.nextInt() - 1);
            this.scanner.nextLine();
    
            // Call the haveSurgery() method on the patient object with the selected speciality name
            this.patient.haveSurgery(speciality.getName());
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException exception) {
            // Handle exceptions for invalid input
            System.out.println("\n Invalid input, please input a number");
            this.haveSurgery();
        }
    }
    
    protected void dischargeInpatient() { 
        // Call the dischargeInpatient() method on the patient object
        this.patient.dischargeInpatient();
    }
    
    protected void admitAsAnInpatient() {
        // Call the admitInpatient() method on the patient object with the department name
        this.patient.admitInpatient(this.department.getName());
    }
    
    protected void outPatientDischarge() {
        // Call the remove() method on the patient repository with the patient object
        this.patientRepository.remove(this.patient);
    }
}
