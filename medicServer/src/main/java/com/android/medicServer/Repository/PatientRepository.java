package com.android.medicServer.Repository;

import com.android.medicServer.Base.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Integer>
{
    List<Patient> findAll();
    List<Patient> findById(int id);
}
