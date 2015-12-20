package com.android.medicServer.Controller;

import com.android.medicServer.Base.Disease;
import com.android.medicServer.Repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class DiseaseController
{
    @Autowired
    private DiseaseRepository repository;

    @RequestMapping("/enfermedades")
    public List<Disease> getDiseases()
    {
        List<Disease> listaEnfermedades = repository.findAll();
        return listaEnfermedades;
    }

    @RequestMapping("/enfermadad")
    List<Disease> findById(int id)
    {
        List<Disease> listaEnfermedades = repository.findById(id);
        return listaEnfermedades;
    }
}
