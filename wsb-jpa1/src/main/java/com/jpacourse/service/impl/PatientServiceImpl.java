package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.enums.BloodType;
import com.jpacourse.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Set<PatientTO> getAll() {
        return patientDao.findAll().stream()
                .map(PatientMapper::mapToTO)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public PatientTO getById(Long id) {
        return PatientMapper.mapToTO(patientDao.findOne(id));
    }

    @Override
    public void removeById(Long id) {
        patientDao.delete(id);
    }

    @Override
    public Set<PatientTO> getPatientsByLastName(String lastName) {
        return patientDao.findAllByLastname(lastName).stream()
                .map(PatientMapper::mapToTO)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Set<VisitTO> getVisitsByPatientsId(Long id) {
        return patientDao.findOne(id).getVisits().stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Set<PatientTO> getPatientsWithMoreThanXVisits(int noOfVisits) {
        return patientDao.findAll().stream()
            .filter(patient -> patient.getVisits().size() > noOfVisits)
            .map(PatientMapper::mapToTO)
            .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Set<PatientTO> getPatientsByAnyOfBloodtype(Set<BloodType> bloodTypes) {
        return patientDao.findAll().stream()
            .filter(patient -> bloodTypes.contains(patient.getBloodType()))
            .map(PatientMapper::mapToTO)
            .collect(Collectors.toCollection(HashSet::new));
    }

}
