package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.PatientEntity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class PatientMapper {

    public static PatientTO mapToTO(PatientEntity patientEntity) {
        if (patientEntity == null)
        {
            return null;
        }

        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setBloodType(patientEntity.getBloodType());

        final Set<VisitTO> pastVisits = patientEntity.getVisits().stream()
                        .filter(visitEntity -> visitEntity.getTime().isBefore(LocalDateTime.now()))
                        .map(VisitMapper::mapToTO)
                        .collect(Collectors.toSet());

        patientTO.setPastVisits(pastVisits);

        return patientTO;
    }

    public static PatientEntity mapToEntity(PatientTO patientTO) {
        if (patientTO == null)
        {
            return null;
        }

        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setBloodType(patientTO.getBloodType());

//        patientEntity.setVisits(patientTO.getPastVisits());

        return patientEntity;

    }

}