package com.jpacourse.mapper;

import com.jpacourse.dto.MedicalTreatmentTO;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;

public class MedicalTreatmentMapper {

    public static MedicalTreatmentTO mapToTO(MedicalTreatmentEntity medicalTreatmentEntity) {
        if (medicalTreatmentEntity == null) {
            return null;
        }

        final MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();

        medicalTreatmentTO.setId(medicalTreatmentEntity.getId());
        medicalTreatmentTO.setDescription(medicalTreatmentEntity.getDescription());
        medicalTreatmentTO.setType(medicalTreatmentEntity.getType());

        return medicalTreatmentTO;

    }

    public static MedicalTreatmentEntity mapToEntity(MedicalTreatmentTO medicalTreatmentTO) {
        if (medicalTreatmentTO == null) {
            return null;
        }
        
        final MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();

        medicalTreatmentEntity.setId(medicalTreatmentTO.getId());
        medicalTreatmentEntity.setDescription(medicalTreatmentTO.getDescription());
        medicalTreatmentEntity.setType(medicalTreatmentTO.getType());

        return medicalTreatmentEntity;


    }
}
