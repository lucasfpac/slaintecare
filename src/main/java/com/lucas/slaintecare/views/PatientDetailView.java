package com.lucas.slaintecare.views;

import com.lucas.slaintecare.entity.Patient;
import com.lucas.slaintecare.enums.DepartmentEnum;
import com.lucas.slaintecare.utils.DepartmentViewsContainer;

public class PatientDetailView extends ConsoleView {

    private final Patient patient;
    private final DepartmentEnum department;
    
    public PatientDetailView(Patient patient, DepartmentEnum department) {
        this.patient = patient;
        this.department = department;
    }
    
    @Override
    public void show() {
        this.printDetails(); // Print patient details
        
        // Create a container to resolve the appropriate view for the department
        DepartmentViewsContainer container = new DepartmentViewsContainer();
        View view = container.resolveView(this.department, this.patient);
        view.show(); // Show the resolved view for the department
    }
    
    private void printDetails() {
       StringBuilder sb = new StringBuilder();
       sb.append("------------------------------------------\n");
       sb.append("NAME: ").append(this.patient.getName()).append("\n"); // Print patient's name
       sb.append("IS IN-PATIENT?: ").append(this.patient.isInpatient() ? "Yes" : "No").append("\n"); // Print whether patient is an in-patient or not
       sb.append("COMPLAINTS: ");
       
       for (String complaint : this.patient.getComplaints()) {
           sb.append(complaint).append(";"); // Print patient's complaints
       }
       sb.append("\n");
       
       if (this.patient.isInpatient()) { // If patient is an in-patient
           sb.append("NEEDS MEDICATION: ").append(this.patient.needsMedication() ? "Yes" : "No").append("\n"); // Print whether patient needs medication or not
           sb.append("NEEDS SURGERY: ").append(this.patient.needsSurgery()? "Yes" : "No").append("\n"); // Print whether patient needs surgery or not
       }
       sb.append("------------------------------------------");
       
       System.out.println(sb.toString()); // Print the patient details summary
    }
}
