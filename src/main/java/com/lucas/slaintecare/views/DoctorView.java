package com.lucas.slaintecare.views;

import com.lucas.slaintecare.entity.Doctor;
import java.util.InputMismatchException;
import java.util.List;
import com.lucas.slaintecare.repository.DoctorRepository;

public class DoctorView extends ConsoleView {
    private final DoctorRepository doctorRepository;
    
    public DoctorView() {
        this.doctorRepository = new DoctorRepository();
    }
    
    @Override
    public void show() {
        this.chooseDoctor();
    }
    
    private void chooseDoctor() {
        // Get the list of doctors from the doctor repository
        List<Doctor> doctorList = this.doctorRepository.getDoctors();
        
        System.out.println("\nWho are you?");
        // Display the list of doctors with their name, specialty, and department
        for (int i = 0; i < doctorList.size(); i++) {
            Doctor doctor = doctorList.get(i);
            System.out.println(i+1 + ". " + doctor.getName() + " - " + doctor.getSpeciality() + " - " + doctor.getDepartment());
        }
        System.out.println("-1. Back");
        System.out.println("Choose one:");
        
        try {
            int option = this.scanner.nextInt(); // Get user input for doctor choice
            if (option == -1) return; // If -1 is chosen, return to previous menu
            
            Doctor doctor = doctorList.get(option -1); // Get the chosen doctor from the list
            new PatientListView(doctor).show(); // Create a new PatientListView with the chosen doctor and show it
        } catch (InputMismatchException | IndexOutOfBoundsException exception) {
            System.out.println("\n Invalid input, please input a number"); // Handle input mismatch exception
            this.chooseDoctor(); // Call chooseDoctor() again to retry input
            return;
        }
        
        this.show(); // Show the DoctorView again after the patient list view is closed
    }
}