package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;

import java.util.Set;

public interface PatientService {

    Set<PatientTO> getAll();
    PatientTO getById(Long id);
    Set<PatientTO> getPatientsByLastName(String lastName);

    void removeById(Long id);
    Set<VisitTO> getVisitsByPatientsId(Long id);
}
