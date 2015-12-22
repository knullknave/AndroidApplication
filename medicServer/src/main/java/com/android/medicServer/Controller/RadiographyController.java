package com.android.medicServer.Controller;

import com.android.medicServer.Base.Radiography;
import com.android.medicServer.Repository.RadiographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RadiographyController
{
    @Autowired
    private RadiographyRepository repository;

    @RequestMapping("/radiografia")
    public List<Radiography> getRayos()
    {
        List<Radiography> listaRayos = repository.findAll();
        return listaRayos;
    }
}
