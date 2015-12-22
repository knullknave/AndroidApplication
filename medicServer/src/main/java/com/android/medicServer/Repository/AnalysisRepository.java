package com.android.medicServer.Repository;

import com.android.medicServer.Base.Analysis;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnalysisRepository extends CrudRepository<Analysis, Integer>
{
        List<Analysis> findAll();
        List<Analysis> findById(int id);
}
