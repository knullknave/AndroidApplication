package com.android.medicServer.Repository;

import com.android.medicServer.Base.Centro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CentroRepository extends CrudRepository<Centro, Integer>
{
    List<Centro> findAll();
    List<Centro> findById(int id);
}
