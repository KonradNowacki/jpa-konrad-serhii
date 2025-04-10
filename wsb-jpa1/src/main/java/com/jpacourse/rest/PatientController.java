package com.jpacourse.rest;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.enums.BloodType;
import com.jpacourse.service.PatientService;
import com.jpacourse.service.impl.PatientServiceImpl;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<Set<PatientTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientTO> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getById(id));
    }

    // Lista 3 zapytanie 1
    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<Set<PatientTO>> getPatientsByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(patientService.getPatientsByLastName(lastName));
    }

    // Lista 3 zapytanie 2
    @GetMapping("/{id}/visits")
    public ResponseEntity<Set<VisitTO>> getVisitsByPatientsID(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getVisitsByPatientsId(id));
    }

    // Lista 3 zapytanie 3
    @GetMapping("/more-than-visits/{noOfVisits}")
    public ResponseEntity<Set<PatientTO>> getPatientsWithMoreThanXVisits(@PathVariable int noOfVisits) {
        return ResponseEntity.ok(patientService.getPatientsWithMoreThanXVisits(noOfVisits));
    }

    // Lista 3 zapytanie 3
    @GetMapping("/has-bloodtype/{bloodtype}")
    public ResponseEntity<Set<PatientTO>> getPatientsByAnyOfBloodtype(@PathVariable Set<BloodType> bloodtype) {
        return ResponseEntity.ok(patientService.getPatientsByAnyOfBloodtype(bloodtype));
    }

}
