package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;

import java.util.Set;


public interface PatientDao extends Dao<PatientEntity, Long> {

    Set<PatientEntity> findAllByLastname(String username);

}
