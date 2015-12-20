package com.android.medicServer.Controller;

import com.android.medicServer.Base.Episode;
import com.android.medicServer.Repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EpisodeController
{
    @Autowired
    private EpisodeRepository repository;

    @RequestMapping("/episodios")
    public List<Episode> getEpisodes()
    {
        List<Episode> listaEpisodios = repository.findAll();
        return listaEpisodios;
    }
}
