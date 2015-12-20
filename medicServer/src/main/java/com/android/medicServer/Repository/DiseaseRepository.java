package com.android.medicServer.Repository;

import com.android.medicServer.Base.Disease;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiseaseRepository extends CrudRepository<Disease, Integer>
{
    List<Disease> findAll();
    List<Disease> findById(int id);
}
