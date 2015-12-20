package com.android.medicServer.Controller;

import com.android.medicServer.Base.Visit;
import com.android.medicServer.Repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitController
{
    @Autowired
    private VisitRepository repository;

    @RequestMapping("/visitas")
    public List<Visit> getVisits()
    {
        List<Visit> listaVisitas = repository.findAll();
        return listaVisitas;
    }
}
