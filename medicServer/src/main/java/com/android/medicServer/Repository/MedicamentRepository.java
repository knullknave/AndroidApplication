package com.android.medicServer.Repository;

import com.android.medicServer.Base.Medicament;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Daniel on 19/12/2015.
 */
public interface MedicamentRepository extends CrudRepository<Medicament, Integer>
{
    List<Medicament> findAll();
    List<Medicament> findById(int id);
}
