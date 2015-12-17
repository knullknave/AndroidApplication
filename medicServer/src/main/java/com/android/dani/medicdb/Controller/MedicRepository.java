package com.android.dani.medicdb.Controller;

import com.android.dani.medicdb.Medic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicRepository extends CrudRepository<Medic, Integer>
{
    List<Medic> findAll();
    List<Medic> findByCollegiateNumber(int collegiateNumber);
}
