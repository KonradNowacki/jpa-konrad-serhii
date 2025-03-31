package com.jpacourse.dto;

import com.jpacourse.persistance.enums.TreatmentType;

public class MedicalTreatmentTO {
    private long id;
    private String description;
    private TreatmentType type;

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

    public TreatmentType getType() {
        return type;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }
}
