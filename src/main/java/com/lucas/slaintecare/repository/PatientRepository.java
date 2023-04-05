package com.lucas.slaintecare.repository;

import com.lucas.slaintecare.entity.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientRepository {
    // List to store patient objects
    private static List<Patient> patientList = new ArrayList<>();
    
    // Method to create a new patient
    public Patient createPatient(String name, String[] complaints) {
        // Generate patient ID based on the size of the patient list
        int patientId = PatientRepository.patientList.size();
        // Create a new patient object
        Patient patient = new Patient(name, patientId, complaints);
        // Add the patient to the patient list
        PatientRepository.patientList.add(patient);
        
        // Return the created patient object
        return patient;
    }
    
    // Method to get all patients
    public List<Patient> getPatients() {
        // Return the patient list
        return PatientRepository.patientList;
    }
    
    // Method to get patients by department
    public List<Patient> getPatients(String department) {
        // Filter the patient list based on department
        return PatientRepository.patientList.stream().filter(patient -> {
            // Check if the patient's department matches the given department
            if (patient.getDepartment().equals(department)) return true;
            // If not, check if the patient's complaint matches the given department
            return patient.getComplaints()[0].equals(department);
        }).collect(Collectors.toList());
    }
    
    // Method to remove a patient
    public void remove(Patient patient) {
        // Filter the patient list to exclude the patient to be removed
        PatientRepository.patientList = PatientRepository.patientList.stream().filter(item -> {
            return item.getPatientId() != patient.getPatientId();
        }).collect(Collectors.toList());
    }
}