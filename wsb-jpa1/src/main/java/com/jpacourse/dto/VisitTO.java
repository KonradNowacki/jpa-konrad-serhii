package com.jpacourse.dto;

import com.jpacourse.persistance.enums.TreatmentType;

import java.time.LocalDateTime;
import java.util.Set;

public class VisitTO {
    private long id;
    private String description;
    private LocalDateTime time;
    private Set<MedicalTreatmentTO> treatmentType;
    private String doctorName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Set<MedicalTreatmentTO> getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentTypes(Set<MedicalTreatmentTO> treatmentType) {
        this.treatmentType = treatmentType;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
