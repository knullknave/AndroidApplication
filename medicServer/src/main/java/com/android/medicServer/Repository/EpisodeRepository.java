package com.android.medicServer.Repository;

import com.android.medicServer.Base.Episode;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EpisodeRepository extends CrudRepository<Episode, Integer>
{
    List<Episode> findAll();
    List<Episode> findById(int id);
}
