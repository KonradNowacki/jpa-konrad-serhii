package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.enums.BloodType;

import java.util.Set;

public interface PatientService {

    Set<PatientTO> getAll();
    PatientTO getById(Long id);
    Set<PatientTO> getPatientsByLastName(String lastName);
    Set<PatientTO> getPatientsWithMoreThanXVisits(int noOfVisits);
    Set<PatientTO> getPatientsByAnyOfBloodtype(Set<BloodType> bloodType);

    void removeById(Long id);
    Set<VisitTO> getVisitsByPatientsId(Long id);
}
