package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.enums.BloodType;
import com.jpacourse.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.jpacourse.persistance.enums.BloodType.A_POSITIVE;
import static com.jpacourse.persistance.enums.BloodType.ZERO_POSITIVE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void zapytanie1TestDAO_testShouldFindPatientsByName_wrongLastName() {
         // when
        final Set<PatientEntity> patientEntities = patientDao.findAllByLastname("wrong name");

        // then
        assertThat(patientEntities).isEmpty();
    }

    @Transactional
    @Test
    public void zapytanie1TestDAO_testShouldFindPatientsByName_correctLastName() {
        // when
        final Set<PatientEntity> patientEntities = patientDao.findAllByLastname("Nowak");

        // then
        assertThat(patientEntities).hasSize(1);
    }

    @Transactional
    @Test
    public void zapytanie1TestDAO_testShouldFindPatientsByName_worksCaseinsensitively() {
        // when
        final Set<PatientEntity> patientEntities = patientDao.findAllByLastname("NOWak");

        // then
        assertThat(patientEntities).hasSize(1);
    }

    @Transactional
    @Test
    public void zapytanie3TestDAO_testShouldHaveMoreThanXVisits() {
        // given
        final int minNumberOfVisits = 2;

        // when
        final Set<PatientEntity> patients = patientDao.getPatientsWithMoreThanXVisits(minNumberOfVisits);

        // then
        assertThat(patients).hasSize(3);
    }

    @Transactional
    @Test
    public void zapytanie4TestDAO_testShouldHaveOneOfTheBloodTypes() {
        // given
        final Set<BloodType> bloodTypes = Set.of(ZERO_POSITIVE, A_POSITIVE);

        // when
        final Set<PatientEntity> patients = patientDao.getPatientsHavingOneOfBloodTypes(bloodTypes);

        // then
        assertThat(patients).hasSize(3);
    }

}
