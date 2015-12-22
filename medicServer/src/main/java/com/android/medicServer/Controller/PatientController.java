package com.android.medicServer.Controller;

import com.android.medicServer.Base.Patient;
import com.android.medicServer.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController
{
    @Autowired
    private PatientRepository repository;

    @RequestMapping("/pacientes")
    public List<Patient> getPatients()
    {
        List<Patient> listaPacientes = repository.findAll();
        return listaPacientes;
    }
}
