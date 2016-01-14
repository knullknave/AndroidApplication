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
            @RequestParam(value = "id") String id,
            @RequestParam(value = "report") String report,
            @RequestParam(value = "medicalcentre") String medicalcentre,
            @RequestParam(value = "visitdate", defaultValue = "nada") String visitdate,
            @RequestParam(value = "idmedic", defaultValue = "nada") String idmedic,
            @RequestParam(value = "idpatient", defaultValue = "nada") String idpatient,
            @RequestParam(value = "idanalysis", defaultValue = "nada") String idanalysis,
            @RequestParam(value = "idepisode", defaultValue = "nada") String idepisode,
            @RequestParam(value = "idradiography", defaultValue = "nada") String idradiography,
            @RequestParam(value = "idpharmacotherapy", defaultValue = "nada") String idpharmacotherapy)
    {
        Visit v = new Visit();
        if(!id.equals("0"))
            v.setId(Integer.valueOf(id));
        if(!report.equals("0"))
            v.setReport(report);
        v.setMedicalCentre(medicalcentre);
        try
        {
            v.setVisitDate(df.parse(visitdate.replace("/", "-")));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        if(!idmedic.equals("0"))
            v.setIdmedic(Integer.valueOf(idmedic));
        if(!idpatient.equals("0"))
            v.setIdpatient(Integer.valueOf(idpatient));
        if(!idanalysis.equals("0"))
            v.setIdanalysis(Integer.valueOf(idanalysis));
        if(!idepisode.equals("0"))
            v.setIdepisode(Integer.valueOf(idepisode));
        if(!idradiography.equals("0"))
            v.setIdradiography(Integer.valueOf(idradiography));
        if(!idpharmacotherapy.equals("0"))
            v.setIdpharmacotherapy(Integer.valueOf(idpharmacotherapy));

        repository.save(v);
    }

    @RequestMapping("/delete_visit")
    public void deleteVisit(int id)
    {
        repository.delete(id);
    }
}
