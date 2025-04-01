package com.jpacourse.service;

import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.VisitDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Test
    @Transactional
    public void testDeletePatient_shouldCascadeDeleteVisitsAndLeaveDoctors() {
        // given
        assertThat(visitDao.findAll().size()).isEqualTo(5);
        assertThat(doctorDao.findAll().size()).isEqualTo(5);

        // when
        patientService.removeById(1L);
        var removedPatient = patientService.getById(1L);

        // then
        assertThat(removedPatient).isNull();
        assertThat(visitDao.findAll().size()).isEqualTo(4);
        assertThat(doctorDao.findAll().size()).isEqualTo(5);
    }

}
