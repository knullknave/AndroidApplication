package com.android.medicServer.Controller;

import com.android.medicServer.Base.Visit;
import com.android.medicServer.Repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class VisitController
{
    @Autowired
    private VisitRepository repository;
	private static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    @RequestMapping("/visitas")
    public List<Visit> getVisits()
    {
        List<Visit> listaVisitas = repository.findAll();
        return listaVisitas;
    }
	
	@RequestMapping("/visita")
    public List<Visit> findById(@RequestParam(value = "id")int id)
    {
        List<Visit> listaVisitas = repository.findById(id);
        return listaVisitas;
    }

    @RequestMapping("/add_visit")
    public void addVisit(
            @RequestParam(value = "medicalcentre") String medicalcentre,
            @RequestParam(value = "visitdate", defaultValue = "nada") String visitdate,
            @RequestParam(value = "idMedic") String idMedic,
            @RequestParam(value = "idPatient") String idPatient)
    {
        Visit v = new Visit();
        v.setMedicalCentre(medicalcentre);
        try
        {
            v.setVisitDate(df.parse(visitdate.replace("/", "-")));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        v.setIdmedic(Integer.valueOf(idMedic));
        v.setIdpatient(Integer.valueOf(idPatient));

        repository.save(v);
    }

    @RequestMapping("/delete_visit")
    public void deleteVisit(String id)
    {
        repository.delete(Integer.valueOf(id));
    }
}
