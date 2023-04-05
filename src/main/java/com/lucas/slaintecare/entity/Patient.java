package com.lucas.slaintecare.entity;

public class Patient {
    private String name;
    private int patientId;
    private boolean inpatient;
    private String[] complaints;

    public Patient(String name, int patientId, String[] complaints) {
        this.name = name;
        this.patientId = patientId;
        this.complaints = complaints;
    }
    
    
    public String getName() {
        return name;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDepartment() {
        return this.complaints[0];
    }

    public boolean isInpatient() {
        return inpatient;
    }

    public String[] getComplaints() {
        return complaints;
    }
    
    public boolean needsMedication() {
        return false;
    }
    
    public boolean needsSurgery() {
        return true;
    }
    
    public void transferDepartment(String department) {
        
    }
    
    public void haveSurgery(String speciality) {
        
    }
    
    public void prescribeMedication(String speciality) {
        
    }
    
    public void admitInpatient(String department) {
        
    }
    
    public void dischargeInpatient() {
        
    }
}
