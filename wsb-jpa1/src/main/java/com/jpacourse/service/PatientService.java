package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

import java.util.Set;

public interface PatientService {

    Set<PatientTO> getAll();
    PatientTO getById(Long id);
    void removeById(Long id);
}
