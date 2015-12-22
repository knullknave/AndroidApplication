package com.android.medicServer.Repository;

import com.android.medicServer.Base.Pharmacotherapy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PharmacotherapyRepository extends CrudRepository<Pharmacotherapy, Integer>
{
    List<Pharmacotherapy> findAll();
    List<Pharmacotherapy> findById(int id);
}
