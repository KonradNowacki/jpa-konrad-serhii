package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.enums.BloodType;

import java.util.Set;


public interface PatientDao extends Dao<PatientEntity, Long> {

    Set<PatientEntity> findAllByLastname(String username);

    Set<PatientEntity> getPatientsWithMoreThanXVisits(int noOfVisits);

    Set<PatientEntity> getPatientsHavingOneOfBloodTypes(Set<BloodType> bloodTypes);

}
