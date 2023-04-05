package com.lucas.slaintecare.entity;

import com.lucas.slaintecare.enums.DepartmentEnum;

public class Doctor {
    private String name;
    private DepartmentEnum department;
    private String speciality;
    private Boolean surgeon;
    private Boolean onDuty;

    public Doctor(String name, DepartmentEnum department, String speciality, Boolean surgeon, Boolean onDuty) {
        this.name = name;
        this.department = department;
        this.speciality = speciality;
        this.surgeon = surgeon;
        this.onDuty = onDuty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentEnum getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEnum department) {
        this.department = department;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Boolean getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(Boolean surgeon) {
        this.surgeon = surgeon;
    }

    public Boolean getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(Boolean onDuty) {
        this.onDuty = onDuty;
    }
    
    
}
