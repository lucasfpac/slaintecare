package com.lucas.slaintecare.views;

import com.lucas.slaintecare.entity.Doctor;
import com.lucas.slaintecare.entity.Patient;
import java.util.InputMismatchException;
import java.util.List;
import com.lucas.slaintecare.repository.PatientRepository;

public class PatientListView extends ConsoleView {

    private final PatientRepository patientRepository;
    private final Doctor doctor;
    
    public PatientListView(Doctor doctor) {
        this.patientRepository = new PatientRepository();
        this.doctor = doctor;
    }
    
    @Override
    public void show() {
        // Retrieve the list of patients from the patient repository for the doctor's department
        List<Patient> patientList = this.patientRepository.getPatients(this.doctor.getDepartment().getName());
        
        System.out.println("select a patient from the following list");
        System.out.println("N. |   NAME   |   IS INPATIENT   |   NEEDS MEDICATION   |   NEEDS SURGERY");
        // Display the details of each patient in the list
        for (Patient patient : patientList) {
            StringBuilder sb = new StringBuilder();
            sb.append(patient.getPatientId()).append(" |  ");
            sb.append(patient.getName()).append(" | ");
            sb.append(patient.isInpatient() ? "Yes" : "No").append(" | ");
            sb.append(patient.needsMedication() ? "Yes" : "No").append(" | ");
            sb.append(patient.needsSurgery() ? "Yes" : "No");
            
            System.out.println(sb.toString());
        }
        System.out.println("-1. Back");
        System.out.println("Choose one:");
        try {
            // Get the user's choice for selecting a patient
            int option = this.scanner.nextInt();
            if (option == -1) return; // If -1 is chosen, go back to previous view
            
            // Retrieve the selected patient from the patient list and display patient details in PatientDetailView
            Patient patient = patientList.get(option);
            new PatientDetailView(patient, doctor.getDepartment()).show();
        } catch (InputMismatchException | IndexOutOfBoundsException exception) {
            System.out.println("\n Invalid input, please input a number");
            this.show();
            return;
        }
        
        this.show(); // Show the view again after processing user's choice
    }
}
