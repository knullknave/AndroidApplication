package com.android.medicServer.Repository;

import com.android.medicServer.Base.Medic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicRepository extends CrudRepository<Medic, Integer>
{
    List<Medic> findAll();
    List<Medic> findById(int id);
}
