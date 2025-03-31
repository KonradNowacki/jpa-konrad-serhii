package com.jpacourse.mapper;

import com.jpacourse.dto.MedicalTreatmentTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class VisitMapper {

    public static VisitTO mapToTO(VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());

        final Set<MedicalTreatmentTO> medicalTreatmentTOs = visitEntity.getMedicalTreatments().stream()
                .map(MedicalTreatmentMapper::mapToTO)
                .collect(Collectors.toSet());

        visitTO.setTreatmentTypes(medicalTreatmentTOs);
        visitTO.setDoctorName(visitEntity.getDoctor().getFirstName() + " " + visitEntity.getDoctor().getLastName());

        return visitTO;
    }

    // TODO KN Remove if not needed
//    public static VisitEntity mapToTO(VisitTO visitTO) {
//        if (visitTO == null) {
//            return null;
//        }
//
//        final VisitEntity visitEntity = new VisitEntity();
//        visitEntity.setDescription(visitTO.getDescription());
//        visitEntity.setTime(visitTO.getTime());
//        visitEntity.setId(visitTO.getId());
//
//        final Set<MedicalTreatmentEntity> medicalTreatmentEntities = visitTO.
//
//        return visitEntity;
//    }

}
