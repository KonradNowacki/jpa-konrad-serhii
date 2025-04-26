package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.enums.BloodType;
import jakarta.persistence.OptimisticLockException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.jpacourse.persistance.enums.BloodType.A_POSITIVE;
import static com.jpacourse.persistance.enums.BloodType.ZERO_POSITIVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        final int MIN_NUMBER_OF_VISITS = 2;

        // when
        final Set<PatientEntity> patients = patientDao.getPatientsWithMoreThanXVisits(MIN_NUMBER_OF_VISITS);

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

    @Test
    public void wersjonowanie_shouldThrowObjectOptimisticLockingFailureException() {
        final long PATIENT_ID = 3L;

        var patient1 = patientDao.findOne(PATIENT_ID);
        var patient2 = patientDao.findOne(PATIENT_ID);

        patient1.setFirstName("Name_1");
        patientDao.update(patient1);

        patient2.setFirstName("Name_2");

        assertThatThrownBy(() -> patientDao.update(patient2))
                .isInstanceOf(ObjectOptimisticLockingFailureException.class);
    }

}
