package com.android.medicServer.Repository;

import com.android.medicServer.Base.Radiography;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RadiographyRepository extends CrudRepository<Radiography, Integer>
{
        List<Radiography> findAll();
        List<Radiography> findById(int id);
}
