// This code defines an enum called "DepartmentEnum" that represents different departments within a healthcare system.
// Each enum value represents a specific department and contains information about the department's capabilities.
package com.lucas.slaintecare.enums;

// Here, we define the different departments as enum values with their corresponding information.
public enum DepartmentEnum {
    Cardiology("Cardiology", true, true, true, true, true),
    Rheumatology("Rheumatology", true, true, true, false, false),
    ENT("ENT", true, true, true, false, true),
    Ophthalmology("Ophthalmology", true, true, true, true, true),
    OccupationalTherapy("Occupational Therapy", true, false, true, false, false),
    Radiology("Radiology", false, false, false, true, false),
    Oncology("Oncology", true, true, true, true, true),
    OB_GYN("OB/GYN", true, true, true, true, true),
    Emergency("Emergency", true, true, true, true, true);
    
    // Private variables to store the values of each department
    private final String name;
    private final boolean canPrescribeMedication;
    private final boolean canAdmitInpatients;
    private final boolean canDischargeInpatients;
    private final boolean canTransferDepartment;
    private final boolean canHaveOperations;

    // Constructor for DepartmentEnum to initialize each department's values
    private DepartmentEnum(String name, boolean canPrescribeMedication, boolean canAdmitInpatients, boolean canDischargeInpatients, boolean canTransferDepartment, boolean canHaveOperations) {
        this.name = name;
        this.canPrescribeMedication = canPrescribeMedication;
        this.canAdmitInpatients = canAdmitInpatients;
        this.canDischargeInpatients = canDischargeInpatients;
        this.canTransferDepartment = canTransferDepartment;
        this.canHaveOperations = canHaveOperations;
    }

    // Getter methods to retrieve department information
    public String getName() {
        return name;
    }

    public boolean isCanPrescribeMedication() {
        return canPrescribeMedication;
    }

    public boolean isCanAdmitInpatients() {
        return canAdmitInpatients;
    }

    public boolean isCanDischargeInpatients() {
        return canDischargeInpatients;
    }

    public boolean isCanTransferDepartment() {
        return canTransferDepartment;
    }

    public boolean isCanHaveOperations() {
        return canHaveOperations;
    }
    
    
}
