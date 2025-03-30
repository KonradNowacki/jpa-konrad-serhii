package com.jpacourse.service.impl;

import com.jpacourse.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {


    @Override
    public String getAllPatients() {
        return "all patients";
    }
}
