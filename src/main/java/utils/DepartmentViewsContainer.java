package utils;

import com.lucas.slaintecare.entity.Patient;
import enums.DepartmentEnum;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import views.View;
import views.department.CardiologyView;
import views.department.DefaultDepartmentView;
import views.department.ENTView;
import views.department.EmergencyView;
import views.department.OBGYNView;
import views.department.OccupationalTherapyView;
import views.department.OncologyView;
import views.department.OphthalmologyView;
import views.department.RadiologyView;
import views.department.RheumatologyView;

public class DepartmentViewsContainer {
    private final Map<DepartmentEnum, Class<?>> map; // Map to store department enum and corresponding view class

    public DepartmentViewsContainer() {
        this.map = new HashMap<>(); // Initialize the map
        // Populate the map with department enum as key and corresponding view class as value
        this.map.put(DepartmentEnum.Cardiology, CardiologyView.class);
        this.map.put(DepartmentEnum.ENT, ENTView.class);
        this.map.put(DepartmentEnum.Emergency, EmergencyView.class);
        this.map.put(DepartmentEnum.OB_GYN, OBGYNView.class);
        this.map.put(DepartmentEnum.OccupationalTherapy, OccupationalTherapyView.class);
        this.map.put(DepartmentEnum.Oncology, OncologyView.class);
        this.map.put(DepartmentEnum.Ophthalmology, OphthalmologyView.class);
        this.map.put(DepartmentEnum.Radiology, RadiologyView.class);
        this.map.put(DepartmentEnum.Rheumatology, RheumatologyView.class);
    }

    /**
     * Resolves and returns a view for a given department and patient.
     *
     * @param department The department enum for which the view needs to be resolved.
     * @param patient    The patient object for which the view needs to be resolved.
     * @return The resolved view object or null if resolution fails.
     */
    public View resolveView(DepartmentEnum department, Patient patient) {
        Class<?> clazz = this.map.get(department); // Get the view class for the given department from the map
        try {
            // Instantiate the view class with the patient object using reflection
            return (View) clazz.getDeclaredConstructor(Patient.class).newInstance(patient);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException |
                NoSuchMethodException | SecurityException | InvocationTargetException exception) {
            // If any exception occurs during view resolution, return null
            return null;
        }
    }
}
