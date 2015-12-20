package com.android.medicServer.Repository;

import com.android.medicServer.Base.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisitRepository  extends CrudRepository<Visit, Integer>
{
    List<Visit> findAll();
    List<Visit> findById(int id);
}